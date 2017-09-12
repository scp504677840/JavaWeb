package filter;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------ SecondFilter init ------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------ SecondFilter start doFilter ------");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("------ SecondFilter end doFilter ------");
    }

    @Override
    public void destroy() {
        System.out.println("------ SecondFilter destroy ------");
    }

}
