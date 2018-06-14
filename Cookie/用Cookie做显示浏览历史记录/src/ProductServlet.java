import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        LinkedHashMap<String, Product> products = Products.getAll();

        String id = request.getParameter("id");
        if (id == null || !products.containsKey(id)) {
            writer.print("商品不存在！！！");
            return;
        }

        Product product = products.get(id);
        writer.print("商品ID：" + product.getId() + "<br>");
        writer.print("商品名称：" + product.getName() + "<br>");
        writer.print("商品价格：" + product.getPrice() + "<br>");
        writer.print("商品描述：" + product.getDesc() + "<br>");


        Cookie cookie = new Cookie("productHistory", makeValue(id, request));
        System.out.println(cookie.getValue());
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

    }

    private String makeValue(String id, HttpServletRequest request) {
        String productHistory = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("productHistory")) {
                    productHistory = cookie.getValue();
                }
            }
        }

        if (productHistory == null) {
            return id;
        }

        LinkedList<String> ids = new LinkedList<>(Arrays.asList(productHistory.split("-")));
        // productHistory=2-3-1
        if (ids.contains(id)) {
            ids.remove(id);
        }
        // productHistory=2-3-4
        else if (ids.size() > 2) {
            ids.removeLast();
        }
        ids.addFirst(id);

        return String.join("-", ids);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
