import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当客户端禁用Cookie时，解决办法如下：
 * 1.response.encodeURL重写URL，将sessionId带在URL的后面。
 *
 * 注意：
 * 采用重写URL这种方式时，就无法像Cookie那样持久化sessionId，也就说
 * 客户端每次结束会话然后再访问服务器时，就是重新创建一个session。
 * 像以前，我们还可以改变存放SessionId的那个Cookie有效时间，
 * 使得客户端结束会话后的一段时间内还保存着我们的SessionID，
 * 而重写URL无法做到！
 */
@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        //当session不存在时，创建session
        request.getSession();

        String setUrl = response.encodeURL("/set");
        String getUrl = response.encodeURL("/get");

        writer.print("<a href='" + setUrl + "'>设置值</a><br>");
        writer.print("<a href='" + getUrl + "'>获取值</a><br>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
