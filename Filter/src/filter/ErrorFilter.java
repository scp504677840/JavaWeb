package filter;

import javax.servlet.*;
import java.io.IOException;

public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------ ErrorFilter init ------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------ ErrorFilter start doFilter ------");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("------ ErrorFilter end doFilter ------");
    }

    @Override
    public void destroy() {
        System.out.println("------ ErrorFilter destroy ------");
    }
}
