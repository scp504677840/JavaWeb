import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/logo.png");
        System.out.println(path);
        String fileName = path.substring(path.lastIndexOf("/") + 1);

        // 英文名称，不会出现乱码
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        // 中文名称，会出现乱码，解决办法如下：
        //response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(path);
            out = response.getOutputStream();

            byte[] buf = new byte[1024];
            int length;

            while (true) {
                length = in.read(buf);
                if (length == 0) {
                    break;
                }
                out.write(buf, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
