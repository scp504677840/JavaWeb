import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示通过静态方式加载资源
        /*BookDao bookDao = new BookDaoImpl();
        bookDao.updateBook(new Book());
        response.getOutputStream().write("hi".getBytes());*/

        // 对比getClassLoader().getResourceAsStream和getClassLoader().getResource
        UserDao userDao = new UserDaoImpl();
        userDao.getUser();
        response.getOutputStream().write("对比getClassLoader().getResourceAsStream和getClassLoader().getResource".getBytes());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
