import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

@WebServlet(name = "LocalServlet", urlPatterns = "/local")
public class LocalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getLocalAddr
        String localAddr = request.getLocalAddr();
        System.out.println("LocalAddr：" + localAddr);

        //getLocale
        Locale locale = request.getLocale();
        plLocal(locale);
        //DisplayCountry：中国
        //DisplayLanguage：中文
        //DisplayName：中文 (中国)
        //DisplayScript：
        //DisplayVariant：

        //getLocales
        Enumeration<Locale> locales = request.getLocales();
        while (locales.hasMoreElements()) {
            Locale element = locales.nextElement();
            System.out.println("----------------------------------");
            plLocal(element);
        }
        //----------------------------------
        //DisplayCountry：中国
        //DisplayLanguage：中文
        //DisplayName：中文 (中国)
        //DisplayScript：
        //DisplayVariant：
        //----------------------------------
        //DisplayCountry：
        //DisplayLanguage：中文
        //DisplayName：中文
        //DisplayScript：
        //DisplayVariant：

        //getLocalName
        String localName = request.getLocalName();
        System.out.println("LocalName：" + localName);
        //LocalName：192.168.0.102

        //getLocalPort
        int localPort = request.getLocalPort();
        System.out.println("LocalPort：" + localPort);
        //LocalPort：8080
    }

    private void plLocal(Locale locale) {
        String country = locale.getDisplayCountry();
        String language = locale.getDisplayLanguage();
        String name = locale.getDisplayName();
        String script = locale.getDisplayScript();
        String variant = locale.getDisplayVariant();
        System.out.println("DisplayCountry：" + country);
        System.out.println("DisplayLanguage：" + language);
        System.out.println("DisplayName：" + name);
        System.out.println("DisplayScript：" + script);
        System.out.println("DisplayVariant：" + variant);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
