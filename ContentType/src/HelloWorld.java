import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "HelloWorld", urlPatterns = {"/hello"})
public class HelloWorld extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置文档属于什么MIME类型。客户端按照服务器返回的文档类型进行解析。
        response.setHeader("Content-Type", "image/png");
        // 获取输入流
        InputStream in = getServletContext().getResourceAsStream("/logo.png");
        // 获取输出流
        ServletOutputStream out = response.getOutputStream();

        // 缓冲区
        byte[] buf = new byte[1024];
        // 每次读取的字节数
        int length;
        // 遍历读取
        while ((length = in.read(buf)) > 0) {
            out.write(buf, 0, length);
        }

        // 关闭流
        in.close();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
