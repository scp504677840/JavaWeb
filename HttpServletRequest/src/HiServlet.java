import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 对比1
 * URL：http://www.baidu.com/news/1.html
 * URI：/news/1.html
 * <p>
 * 对比2
 * URL：标识一个互联网资源
 * URI：标识一个资源
 * <p>
 * 对比3
 * URL：范围没有URI大（子）
 * URI：范围比URL大，标识范围包括URL（父）
 */
@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getAuthType
        String authType = request.getAuthType();
        System.out.println("认证类型：" + authType);

        //getHttpServletMapping
        HttpServletMapping httpServletMapping = request.getHttpServletMapping();
        System.out.println("Servlet映射getMatchValue：" + httpServletMapping.getMatchValue());
        System.out.println("Servlet映射getPattern：" + httpServletMapping.getPattern());
        System.out.println("Servlet映射getServletName：" + httpServletMapping.getServletName());
        System.out.println("Servlet映射getMappingMatch：" + httpServletMapping.getMappingMatch());
        //Servlet映射getMatchValue：hi
        //Servlet映射getPattern：/hi
        //Servlet映射getServletName：HiServlet
        //Servlet映射getMappingMatch：EXACT

        //getMethod
        String method = request.getMethod();
        System.out.println("请求方法：" + method);

        //getQueryString
        String queryString = request.getQueryString();
        System.out.println("QueryString：" + queryString);

        //isUserInRole
        boolean isUserInRole = request.isUserInRole(request.getRemoteUser());
        System.out.println("isUserInRole：" + isUserInRole);

        //返回包含当前已通过身份验证的用户名称的java.security.Principal对象。
        //getUserPrincipal
        //Principal userPrincipal = request.getUserPrincipal();
        //System.out.println("userPrincipal.getName：" + userPrincipal.getName());

        //getRequestURI
        String uri = request.getRequestURI();
        System.out.println("uri：" + uri);
        //uri：/hi

        //getRequestURL
        StringBuffer url = request.getRequestURL();
        System.out.println("url：" + url);
        //url：http://localhost:8080/hi

        //authenticate

        //login
        //logout

        //upgrade

        //getTrailerFields
        Map<String, String> trailerFields = request.getTrailerFields();
        trailerFields.forEach((s, s2) -> {
            System.out.println("TrailerFields->" + s + ":" + s2);
        });

        //getCharacterEncoding
        //getContentLength
        //getContentLengthLong
        //getContentType
        //getDispatcherType
        //getInputStream
        //getReader
        //getRequestDispatcher
        //getServletContext
        //isSecure

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
