import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServerServlet", urlPatterns = "/server")
public class ServerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getScheme
        String scheme = request.getScheme();
        System.out.println("Scheme：" + scheme);
        //Scheme：http

        //getProtocol
        String protocol = request.getProtocol();
        System.out.println("Protocol：" + protocol);
        //Protocol：HTTP/1.1

        //getServerName
        String serverName = request.getServerName();
        System.out.println("ServerName：" + serverName);
        //ServerName：localhost

        //getServerPort
        int serverPort = request.getServerPort();
        System.out.println("ServerPort：" + serverPort);
        //ServerPort：8080

        //已过时
        //getRealPath
        //String realPath = request.getRealPath("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
