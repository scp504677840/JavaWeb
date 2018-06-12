import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 一、loadOnStartup：随着容器启动时启动。
 * <p>
 * 二、urlPatterns = {"/"}：
 * 1.配置首页
 * 2.覆盖容器默认缺省值（/）。
 * <p>
 * 三、ServletConfig：配置Servlet初始化时传递的配置参数。
 * <p>
 */
@WebServlet(name = "HiServlet", urlPatterns = {"/"}, loadOnStartup = 2,
        initParams = {@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/test"),
                @WebInitParam(name = "username", value = "root"),
                @WebInitParam(name = "password", value = "scp15335747148")})
public class HiServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        Enumeration<String> parameterNames = config.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            String value = getServletConfig().getInitParameter(element);
            System.out.println(element + ":" + value);
        }

        System.out.println("ServletInfo:" + getServletInfo());
        System.out.println("ServletName:" + getServletName());

        System.out.println("getServletConfig().getServletName:" + getServletConfig().getServletName());

        response.getOutputStream().write("hi".getBytes());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("---init---");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("---destroy---");
    }

}
