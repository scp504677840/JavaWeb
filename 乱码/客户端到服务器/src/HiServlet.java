import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //testPost(request);
        testGet(request);
    }

    private void testGet(HttpServletRequest request) throws UnsupportedEncodingException {
        // 解决request乱码问题，只对Get有效。
        String name = request.getParameter("name");
        //其中getBytes第一个参数是客户端（浏览器）的编码格式，这里写StandardCharsets.ISO_8859_1只是举例。
        //第一步：将乱码对字符按照客户端（浏览器）的编码格式重新编一次，得到原始数据。
        //第二步：将原始数据按照UTF-8编一次得到正确的字符。
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(name);
    }

    private void testPost(HttpServletRequest request) throws UnsupportedEncodingException {
        // 解决request乱码问题，只对POST有效。
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.println(name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
