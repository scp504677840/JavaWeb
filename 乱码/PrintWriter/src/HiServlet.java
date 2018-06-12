import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HiServlet",urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 指定浏览器以什么编码表打开数据；以下两种方式二选一。
        // 方式一：完整写法
        //response.setHeader("Content-Type","text/html;charset=UTF-8");
        // 方式二：简写
        response.setContentType("text/html;charset=UTF-8");

        // 设置response使用的编码表；
        // 注意：如果设置了response.setContentType("text/html;charset=UTF-8");下面这代码可以不用写，
        // 因为response.setContentType("text/html;charset=UTF-8");内部已经设置了response.setCharacterEncoding("UTF-8");
        // 但是还是建议写上。
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("中国");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
