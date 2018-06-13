import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getRequestedSessionId
        String requestedSessionId = request.getRequestedSessionId();
        System.out.println("RequestedSessionId：" + requestedSessionId);
        //RequestedSessionId：CA0488102ED6CF876CCD80EEA74EF145

        //getSession
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        System.out.println("request.getSession.sessionId：" + sessionId);
        //request.getSession.sessionId：CA0488102ED6CF876CCD80EEA74EF145

        //getSession
        HttpSession sessionTrue = request.getSession(true);
        String sessionTrueId = session.getId();
        System.out.println("request.getSession.sessionTrueId：" + sessionId);
        //request.getSession.sessionTrueId：CA0488102ED6CF876CCD80EEA74EF145

        HttpSession sessionFalse = request.getSession(false);
        String sessionFalseId = session.getId();
        System.out.println("request.getSession.sessionFalseId：" + sessionId);
        //request.getSession.sessionFalseId：CA0488102ED6CF876CCD80EEA74EF145

        //changeSessionId
        String changeSessionId = request.changeSessionId();
        System.out.println("changeSessionId：" + changeSessionId);
        //changeSessionId：F5D7D846970FB637B1226D7CEBA5B645

        //isRequestedSessionIdValid
        boolean valid = request.isRequestedSessionIdValid();
        System.out.println("isRequestedSessionIdValid：" + valid);
        //isRequestedSessionIdValid：true

        //isRequestedSessionIdFromCookie
        boolean fromCookie = request.isRequestedSessionIdFromCookie();
        System.out.println("isRequestedSessionIdFromCookie：" + fromCookie);
        //isRequestedSessionIdFromCookie：true

        //isRequestedSessionIdFromURL
        boolean fromURL = request.isRequestedSessionIdFromURL();
        System.out.println("isRequestedSessionIdFromURL：" + fromURL);
        //isRequestedSessionIdFromURL：false

        //isRequestedSessionIdFromUrl
        boolean fromUrl = request.isRequestedSessionIdFromUrl();
        System.out.println("isRequestedSessionIdFromUrl：" + fromUrl);
        //isRequestedSessionIdFromUrl：false
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
