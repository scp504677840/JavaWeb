import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getCookies
        Cookie[] cookieList = request.getCookies();
        for (Cookie cookie : cookieList) {
            System.out.println("CookieName：" + cookie.getName());
        }

        //getHeaders
        Enumeration<String> cookies = request.getHeaders("Cookie");
        while (cookies.hasMoreElements()) {
            String cookie = cookies.nextElement();
            System.out.println("cookie：" + cookie);
        }
        //cookie：Idea-88309e87=dd831e6e-edcf-4a83-8162-7375ec798a1c; JSESSIONID=99ABB9B013BF59B82043BFDDECC63176
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
