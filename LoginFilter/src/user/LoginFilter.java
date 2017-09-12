package user;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //---------- 编码转换 start ----------
        //手写情况
        //request.setCharacterEncoding("UTF-8");

        //FilterConfig情况
        String charset = filterConfig.getInitParameter("Charset");
        if (!"UTF-8".equals(charset)) {
            charset = "UTF-8";
        }
        request.setCharacterEncoding(charset);

        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");

        //---------- 编码转换 end ----------

        //手写情况
        /*if (username != null
                || request.getRequestURL().indexOf("login.jsp") > 0
                || request.getRequestURL().indexOf("/user/login") > 0) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }*/

        //FilterConfig情况
        if (username != null || noFilter(request.getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        response.sendRedirect("/login.jsp");

    }

    private boolean noFilter(String requestURI) {
        String noLoginFilter = filterConfig.getInitParameter("NoLoginFilter");
        if (noLoginFilter == null) {
            return true;
        }
        String[] params = noLoginFilter.split(";");
        for (String param : params) {
            if (requestURI.contains(param)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
    }

}
