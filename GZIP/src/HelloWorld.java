import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

@WebServlet(name = "HelloWorld", urlPatterns = {"/hello"})
public class HelloWorld extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 原始数据
        String data = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        // 原始数据大小
        System.out.println("length:" + data.getBytes().length);

        // 字节数组输出流
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        // GZIP压缩输出
        GZIPOutputStream gout = new GZIPOutputStream(bout);
        // 写入
        gout.write(data.getBytes());
        // 关闭流
        gout.close();
        // 得到压缩后的字节数组
        byte[] gzip = bout.toByteArray();

        // 在压缩完数据后，一定要告诉客户端我这是压缩了的数据
        response.setHeader("Content-Encoding", "gzip");
        // 同时也要告诉客户端压缩后的数据大小
        response.setHeader("Content-Length", gzip.length + "");
        // 输出到客户端
        response.getOutputStream().write(gzip);

        // 运行结果：
        // 原始数据大小：510
        // 压缩后数据大小：26
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
