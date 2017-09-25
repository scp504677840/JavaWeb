package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginFilter extends HttpFilter {

    private ServletContext mContext;
    private String mLoginPage;
    private List<String> mNoLoginFilterUrls;

    @Override
    public void init() throws ServletException {
        mContext = getServletContext();

        //获取登录页面
        mLoginPage = mContext.getInitParameter("LoginPage");

        //获取免登陆访问的URL集合
        String noLoginFilterUrl = mContext.getInitParameter("NoLoginFilterUrl");
        mNoLoginFilterUrls = Arrays.asList(noLoginFilterUrl.split(","));
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();

        System.out.println("--- url " + url);
        System.out.println("--- uri " + uri);
        System.out.println("--- contextPath " + contextPath);
        System.out.println("--- servletPath " + servletPath);
        //--- url http://localhost:8080/
        //--- uri /
        //--- contextPath
        //--- servletPath /index.jsp*/

        //获取ServletPath
        String servletPath = request.getServletPath();

        //当免登陆URL集中包含ServletPath时
        if (mNoLoginFilterUrls.contains(servletPath)) {
            chain.doFilter(request, response);
            return;
        }

        //获取session
        HttpSession session = request.getSession();
        //获取用户名
        Object username = session.getAttribute("username");
        //当用户名为空时
        if (username == null) {
            //转发至登录界面
            response.sendRedirect(request.getContextPath() + mLoginPage);
            return;
        }

        chain.doFilter(request, response);

    }
}
