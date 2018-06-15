import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 提供一种通过多个页面请求识别用户或访问网站并存储关于该用户的信息的方法。
 * servlet容器使用此接口在HTTP客户端和HTTP服务器之间创建会话。会话持续一段指定的时间段，跨越来自用户的多个连接或页面请求。会话通常对应于一个用户，他可能会多次访问某个网站。服务器可以通过许多方式维护会话，例如使用cookie或重写URL。
 *
 * 这个接口允许servlets
 * 1.查看和处理有关会话的信息，例如会话标识符，创建时间和上次访问时间
 * 2.将对象绑定到会话，允许用户信息在多个用户连接中保留
 *
 * 当应用程序在会话中存储对象或从会话中删除对象时，会话将检查对象是否实现HttpSessionBindingListener。如果是这样，servlet会通知该对象它已经绑定或从会话中解除绑定。绑定方法完成后发送通知。对于已失效或失效的会话，在会话失效或失效后发送通知。
 *
 * 当容器在分布式容器设置中的VM之间迁移会话时，会通知实现HttpSessionActivationListener接口的所有会话属性。
 *
 * 一个servlet应该能够处理客户端不会选择加入会话的情况，例如当cookie被有意关闭时。在客户端加入会话之前，isNew返回true。如果客户端选择不加入会话，getSession将在每个请求中返回一个不同的会话，isNew将始终返回true。
 *
 * 会话信息仅限于当前Web应用程序（ServletContext），因此存储在一个上下文中的信息将不会在另一个上下文中直接显示。
 */
@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取session，当session不存在时创建session
        //HttpSession session = request.getSession(true);
        // 获取session，当session不存在时不创建session；应用场景：查看购物车。
        //HttpSession session = request.getSession(false);

        HttpSession session = request.getSession();
        session.setAttribute("name", "tom");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
