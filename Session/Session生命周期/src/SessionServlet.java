import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 演示session Id 存放中cookie 中
 *
 * Session
 * 1.当session已经创建时，下次访问时不再创建session。
 * 2.session在客户端访问时创建，在30分钟（默认生命时间）后销毁。
 * 3.在web.xml中配置session-config，然后中session-timeout标签中配置session有效时间，单位为分钟。
 */
@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // java servlet 里 sessionID 存到cookie中name为"JSESSIONID"
                if (cookie.getName().equals("JSESSIONID")) {
                    String value = cookie.getValue();
                    System.out.println(sessionId.equals(value));
                }
            }
        }

        // 销毁session
        session.invalidate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
