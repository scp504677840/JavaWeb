import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PathServlet", urlPatterns = "/path")
public class PathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getPathInfo
        String pathInfo = request.getPathInfo();
        System.out.println("PathInfo：" + pathInfo);
        //PathInfo：null

        //getPathTranslated
        String pathTranslated = request.getPathTranslated();
        System.out.println("PathTranslated：" + pathTranslated);
        //PathTranslated：null

        //getContextPath
        String contextPath = request.getContextPath();
        System.out.println("ContextPath：" + contextPath);
        //ContextPath：

        //getServletPath
        String servletPath = request.getServletPath();
        System.out.println("ServletPath：" + servletPath);
        //ServletPath：/path
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
