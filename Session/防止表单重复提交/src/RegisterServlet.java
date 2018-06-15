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

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("token") == null) {
            response.setStatus(500);
            writer.print("<h3>注册失败！！！</h3>");
            return;
        }
        String token = (String) session.getAttribute("token");

        String userToken = request.getParameter("token");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!token.equals(userToken)) {
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
