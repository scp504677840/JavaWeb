import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        //当验证码为中文或提交过来的数据中有中文时，记得解决乱码问题。
        //注意：这里的UTF-8视情况而定，看客户端编码是什么就写什么。
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("token") == null) {
            response.setStatus(500);
            writer.print("<h3>注册失败！！！</h3>");
            return;
        }

        //服务器端：防止表单重复提交的token
        String token = (String) session.getAttribute("token");
        //服务器端：验证码
        String code = (String) session.getAttribute("code");

        //用户端：防止表单重复提交的token
        String userToken = request.getParameter("token");
        //用户端：验证码
        String userCode = request.getParameter("code");
        //用户名
        String username = request.getParameter("username");
        //密码
        String password = request.getParameter("password");

        //当表单token不一致或验证码不一致时
        if (!token.equals(userToken) || !code.equalsIgnoreCase(userCode)) {
            response.setStatus(500);
            writer.print("<h3>注册失败！！！</h3>");
            return;
        }

        // 移除token
        session.removeAttribute("token");

        System.out.println(username + "：" + password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("token", Token.generate());

        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}