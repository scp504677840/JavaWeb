import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

/**
 * 用Session实现简易购物车
 * <p>
 * 注意：
 * 1.一定要考虑客户端禁用Cookie这种情况。
 * 2.重写URL：response.encodeURL
 * 3.重写重定向URL：response.encodeRedirectURL
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        // 当Session不存在时创建Session
        request.getSession();

        writer.print("店铺首页<br>");

        LinkedHashMap<String, Product> products = Products.getAll();
        products.forEach((id, product) -> {
            // 预防客户端禁用Cookie
            String url = response.encodeURL("/buy?id=" + id);
            writer.print("<a href='" + url + "'>" + product.getName() + "</a><br>");
        });

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
