import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("您上次访问的时间：");

        // 当客户端已经带Cookie过来时
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastAccessTime")) {
                    long time = Long.parseLong(cookie.getValue());
                    String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(time));
                    writer.write(format);
                }
            }
        }

        Cookie cookie = new Cookie("lastAccessTime", String.valueOf(System.currentTimeMillis()));
        cookie.setPath("/");
        //expiry - 一个整数，指定以秒为单位的cookie的最大年龄; 如果为否，则表示cookie未被存储; 如果为零，则删除该Cookie
        cookie.setMaxAge(60);
        response.addCookie(cookie);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
