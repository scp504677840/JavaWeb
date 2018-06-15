import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@WebServlet(name = "BuyServlet", urlPatterns = "/buy")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session
        HttpSession session = request.getSession(false);

        //当session为空时，跳转首页
        if (session == null) {
            response.sendRedirect("/home");
            return;
        }

        LinkedHashMap<String, Product> products = Products.getAll();
        String id = request.getParameter("id");
        if (id == null || !products.containsKey(id)) {
            response.sendRedirect("/home");
            return;
        }

        Product product = products.get(id);
        Object cart = session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Product>();
        }
        ((ArrayList<Product>) cart).add(product);
        session.setAttribute("cart", cart);

        // 预防客户端禁用Cookie，导致sessionId无法继续传递
        String url = response.encodeRedirectURL("/cart");
        response.sendRedirect(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
