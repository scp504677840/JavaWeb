import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/head.jsp").include(request, response);
        response.getWriter().write("Hi,Body!");
        request.getRequestDispatcher("/foot.jsp").include(request, response);
    }
    //包含之后的实际页面代码如下图所示，比较臃肿，不建议使用这种包含技术。
    //小提示：下面代码中，head.jsp和foot.jsp最好可以把该删的都删掉，只留下关键性的东西。
    /*
    <html>
<head>
    <title>Head</title>
</head>
<body>
<h1>Head</h1>
</body>
</html>
Hi,Body!

<html>
<head>
    <title>Foot</title>
</head>
<body>
<h1>Foot</h1>
</body>
</html>
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
