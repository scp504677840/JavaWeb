import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/home");
            return;
        }

        Object cart = session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Product>();
        }

        writer.print("购物车：<br>");

        ((ArrayList<Product>) cart).forEach(product -> {
            writer.print("商品ID：" + product.getId() + "<br>");
            writer.print("商品名称：" + product.getName() + "<br>");
            writer.print("商品价格：" + product.getPrice() + "<br>");
            writer.print("商品描述：" + product.getDesc() + "<br>");
            writer.print("----------------------------------<br>");
        });

        String url = response.encodeURL("/home");
        writer.print("<a href='" + url + "'>首页</a>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
