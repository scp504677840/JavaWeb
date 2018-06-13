import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "HeaderServlet",urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getDateHeader
        long expires = request.getDateHeader("Expires");
        System.out.println("缓存过期时间：" + new SimpleDateFormat("yyyy-MM-dd").format(new Date(expires)));
        //缓存过期时间：1970-01-01

        //getHeader
        String contentType = request.getHeader("Content-Type");
        System.out.println("解析内容类型：" + contentType);
        //解析内容类型：null

        //getHeaders
        Enumeration<String> cookies = request.getHeaders("Cookie");
        while (cookies.hasMoreElements()) {
            String cookie = cookies.nextElement();
            System.out.println("cookie：" + cookie);
        }
        //cookie：Idea-88309e87=dd831e6e-edcf-4a83-8162-7375ec798a1c; JSESSIONID=99ABB9B013BF59B82043BFDDECC63176

        //getHeaderNames
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            System.out.println("headerName：" + element);
        }
        //headerName：host
        //headerName：connection
        //headerName：upgrade-insecure-requests
        //headerName：user-agent
        //headerName：accept
        //headerName：accept-encoding
        //headerName：accept-language
        //headerName：cookie

        //getIntHeader
        int contentLength = request.getIntHeader("Content-Length");
        System.out.println("ContentLength：" + contentLength);
        //ContentLength：-1

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
