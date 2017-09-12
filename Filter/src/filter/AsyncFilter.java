package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "asyncFilter", value = {"/servlet/AsyncServlet"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.ASYNC}, asyncSupported = true)
public class AsyncFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------ AsyncFilter init ------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------ AsyncFilter start doFilter ------");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("------ AsyncFilter end doFilter ------");
    }

    @Override
    public void destroy() {
        System.out.println("------ AsyncFilter destroy ------");
    }
}
