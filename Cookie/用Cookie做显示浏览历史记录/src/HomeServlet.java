import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

/**
 * 特别注意：
 * 1.Cookie的value里面不允许出现逗号（,）
 */
@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        writer.print("商品列表：<br>");
        LinkedHashMap<String, Product> products = Products.getAll();
        products.forEach((id, product) -> {
            writer.print("<a href='/product?id=" + id + "' target='_blank'>" + product.getName() + "</a><br>");
        });

        writer.print("曾经浏览过的商品列表：<br>");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("productHistory")) {
                    String[] ids = cookie.getValue().split("-");
                    for (String id : ids) {
                        Product product = products.get(id);
                        if (product != null) {
                            writer.print(product.getName() + "<br>");
                        }
                    }
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
