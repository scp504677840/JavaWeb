import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 防盗链
 */
@WebServlet(name = "ChainServlet", urlPatterns = "/chain")
public class ChainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String referer = request.getHeader("referer");

        if (referer == null || !referer.startsWith("http://localhost")) {
            response.sendRedirect("/error.jsp");
            return;
        }

        String data = "正文";
        response.getWriter().write(data);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
