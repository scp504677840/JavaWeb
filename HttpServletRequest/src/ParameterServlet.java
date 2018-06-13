import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.BiConsumer;

@WebServlet(name = "ParameterServlet", urlPatterns = "/parameter")
public class ParameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getParameter
        String parameter = request.getParameter("name");
        System.out.println("parameter：" + parameter);
        //parameter：tom

        //getParameterMap
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((key, value) -> System.out.println(key + "：" + Arrays.toString(value)));
        //name：[tom]
        //age：[20]

        //getParameterNames
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name + "：" + request.getParameter(name));
        }
        //name：tom
        //age：20

        //getParameterValues
        String[] values = request.getParameterValues("name");
        if (values != null) {
            for (String value : values) {
                System.out.println("value：" + value);
            }
        }
        //value：tom
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
