import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AsyncServlet", urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //startAsync
        AsyncContext startAsync = request.startAsync();
        startAsync.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                System.out.println("---onComplete---" + asyncEvent);
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                System.out.println("---onTimeout---" + asyncEvent);
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                System.out.println("---onError---" + asyncEvent);
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                System.out.println("---onStartAsync---" + asyncEvent);
            }
        });
        //先调用的是onTimeout再调用的是onComplete
        //---onTimeout---javax.servlet.AsyncEvent@699fc1a5
        //---onComplete---javax.servlet.AsyncEvent@699fc1a5

        //执行异步操作，但是最后记得给客户端返回数据；
        //正是因为要给客户端返回数据，所以才将AsyncContext传递过去。
        new Thread(new AsyncTask(startAsync)).start();

        //使用自定义到request和response
        //startAsync
        //AsyncContext asyncContext = request.startAsync(request, response);
        //System.out.println(asyncContext);

        //isAsyncStarted
        boolean asyncStarted = request.isAsyncStarted();
        System.out.println("isAsyncStarted：" + asyncStarted);
        //isAsyncStarted：true

        //isAsyncSupported
        boolean asyncSupported = request.isAsyncSupported();
        System.out.println("isAsyncSupported：" + asyncSupported);
        //isAsyncSupported：true

        //getAsyncContext
        AsyncContext asyncContext = request.getAsyncContext();
        System.out.println("AsyncContext：" + asyncContext);
        //AsyncContext：org.apache.catalina.core.AsyncContextImpl@55f6d958

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private class AsyncTask implements Runnable {

        private final AsyncContext asyncContext;

        public AsyncTask(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {
            HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            try {
                Thread.sleep(1000 * 3);
                response.getWriter().write("久等了。");
            } catch (IOException | InterruptedException e) {
                response.setStatus(500);
            }
        }
    }
}
