import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ArrayList<User> users = Users.getAll();

        if (username == null || password == null) {
            //登录失败，回到首页
            writer.print("<a href='/home'>登录失败，回到首页</a>");
            return;
        }

        User user = null;
        for (User item : users) {
            if (item.getUsername().equalsIgnoreCase(username) && item.getPassword().equalsIgnoreCase(password)) {
                user = item;
            }
        }

        if (user == null) {
            writer.print("<a href='/home'>登录失败，回到首页</a>");
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        String url = response.encodeRedirectURL("/home");
        response.sendRedirect(url);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
