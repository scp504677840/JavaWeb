import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HiServlet", urlPatterns = "/login")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 方式一
        //fun1(request, response);

        // 方式二【强烈推荐，实际开发中用到的。】
        String message = "<meta http-equiv='Refresh' content='3;url=/index.jsp'>恭喜您，登录成功！3秒后跳到首页，立即跳转，请点击<a href='/index.jsp'>超链接</a>";
        getServletContext().setAttribute("message", message);
        getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }

    /**
     * 方式一
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    private void fun1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        response.setHeader("Refresh", "3;url='/index.jsp'");
        response.getWriter().write("恭喜您，登录成功！3秒后跳到首页，立即跳转，请点击<a href='/index.jsp'>超链接</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
