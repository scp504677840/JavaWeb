import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 同一个请求才可以获取到Attribute
 */
@WebServlet(name = "AttributeServlet", urlPatterns = "/attribute")
public class AttributeServlet extends HttpServlet {

    private int num = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getAttribute
        Object numObj = request.getAttribute("num");
        System.out.println("num：" + numObj);

        //getAttributeNames
        Enumeration<String> names = request.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println("getAttributeNames -> " + name + " : " + request.getAttribute(name));
        }

        //removeAttribute
        request.removeAttribute("name");

        //setAttribute
        request.setAttribute("num", num++);
        request.setAttribute("name", "jay");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
