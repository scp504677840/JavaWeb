import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RDServlet", urlPatterns = "/rd")
public class RDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 下面使用的是ServletContext实现数据转发
        // 不过非常不建议使用ServletContext来实现数据转发，因为会发生线程安全问题；
        // 例如：小明和小红同时访问同一个Servlet，
        // 小明先调用servletContext.setAttribute("name", "小明");
        // 紧接着小红马上也调用了servletContext.setAttribute("name", "小红");
        // 由于是多线程，所以有可能小明在小红设置完servletContext的Attribute属性后马上要获取到里面的内容，
        // 于是小明servletContext.getAttribute("name")得到的却是：小红。
        // 这种线程安全问题绝对不能发生，所以非常不建议使用ServletContext实现数据转发。
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("name", "tom");

        // 转发
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/rd.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
