import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "HiServlet", urlPatterns = {"/hi"})
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置下载请求头
        response.setHeader("Content-Disposition", "attachment;filename=logo.png");

        // 输入流
        InputStream in = getServletContext().getResourceAsStream("/logo.png");
        // 输出流
        ServletOutputStream out = response.getOutputStream();
        // 缓冲区
        byte[] buf = new byte[1024];
        // 读取长度
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
