import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PathServlet", urlPatterns = "/part")
public class PartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getParts
        /*Collection<Part> parts = request.getParts();
        parts.forEach(part -> {
            System.out.println("part.getName：" + part.getName());
            System.out.println("part.getSubmittedFileName：" + part.getSubmittedFileName());
        });*/

        //getPart
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
