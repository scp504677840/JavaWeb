import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60);//一小时
        response.addCookie(cookie);

        /*
        重写前：
        创建时间
        2018年6月15日星期五 上午10:22:01
        到期时间
        浏览会话结束时

        重写后：
        创建时间
        2018年6月15日星期五 上午10:22:01
        到期时间
        2018年6月15日星期五 上午11:22:05
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
