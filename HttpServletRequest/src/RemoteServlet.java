import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoteServlet", urlPatterns = "/remote")
public class RemoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getRemoteUser
        String remoteUser = request.getRemoteUser();
        System.out.println("RemoteUser：" + remoteUser);
        //RemoteUser：null

        //getRemoteAddr
        String remoteAddr = request.getRemoteAddr();
        System.out.println("RemoteAddr：" + remoteAddr);
        //RemoteAddr：192.168.0.101

        //getRemoteHost
        String remoteHost = request.getRemoteHost();
        System.out.println("RemoteHost：" + remoteHost);
        //RemoteHost：192.168.0.101

        //getRemotePort
        int remotePort = request.getRemotePort();
        System.out.println("RemotePort：" + remotePort);
        //RemotePort：55643
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
