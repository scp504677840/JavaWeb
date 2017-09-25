package servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AsyncServlet", asyncSupported = true, urlPatterns = "/servlet/AsyncServlet")
public class AsyncServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet开始执行业务时间：" + new Date());
        AsyncContext async = request.startAsync();
        //开启异步线程
        new Thread(new Executor(async)).start();
        System.out.println("Servlet结束执行业务时间：" + new Date());
    }

    public class Executor implements Runnable {

        private AsyncContext context;

        public Executor(AsyncContext context) {
            this.context = context;
        }

        @Override
        public void run() {
            try {
                //执行复杂业务
                ServletRequest request = context.getRequest();
                ServletResponse response = context.getResponse();
                Thread.sleep(10 * 1000);
                System.out.println("业务执行完成时间：" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
