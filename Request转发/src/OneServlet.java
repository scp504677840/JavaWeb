import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注意事项：
 * 1.以下两句代码最好不要出现。
 * response.getWriter().close();
 * 或
 * response.getOutputStream().close();
 * 如果出现，请不要在后面继续输出数据。
 * response.getWriter().write("data");
 * 或
 * response.getOutputStream().write("data".getBytes());
 *
 * 2.不要在forward之前写数据。如下：
 * response.getOutputStream().write("data".getBytes());//警告
 * request.getRequestDispatcher("/one.jsp").forward(request, response);
 * forward调用之前会将response的数据清掉。
 *
 * 3.不要调用两次forward。如下：
 * request.getRequestDispatcher("/one.jsp").forward(request, response);
 * request.getRequestDispatcher("/one.jsp").forward(request, response);
 *
 */
@WebServlet(name = "OneServlet", urlPatterns = "/one")
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "Hi,Attr";
        request.setAttribute("data", data);
        request.getRequestDispatcher("/one.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
