package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器
 *
 * 过滤器启动后调用顺序
 * ------init------
 * ------start doFilter------
 * ------end doFilter------
 * ------start doFilter------
 * ------end doFilter------
 * ------start doFilter------
 * ------end doFilter------
 * 服务器关闭时调用
 * ------destroy------
 *
 * 当有多个过滤器时，启动后调用顺序
 * ------ SecondFilter init ------
 * ------ FirstFilter init ------
 * ------ FirstFilter start doFilter ------
 * ------ SecondFilter start doFilter ------
 * 处理过程完成！（页面输出）
 * ------ SecondFilter end doFilter ------
 * ------ FirstFilter end doFilter ------
 * ------ FirstFilter start doFilter ------
 * ------ SecondFilter start doFilter ------
 * 处理过程完成！（页面输出）
 * ------ SecondFilter end doFilter ------
 * ------ FirstFilter end doFilter ------
 * ------ FirstFilter start doFilter ------
 * ------ SecondFilter start doFilter ------
 * 处理过程完成！（页面输出）
 * ------ SecondFilter end doFilter ------
 * ------ FirstFilter end doFilter ------
 * 服务器关闭时调用
 * ------ SecondFilter destroy ------
 * ------ FirstFilter destroy ------
 */
public class FirstFilter implements Filter {

    /**
     * 初始化时调用
     *
     * @param filterConfig 过滤配置
     * @throws ServletException 异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------ FirstFilter init ------");
    }

    /**
     * 过滤
     *
     * @param servletRequest  请求
     * @param servletResponse 响应
     * @param filterChain     过滤链
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------ FirstFilter start doFilter ------");
        //filterChain.doFilter(servletRequest,servletResponse);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getContextPath() + "/main.jsp";
        System.out.println(url);
        //重定向，是通过response来触发的
        response.sendRedirect(url);
        //转发，是通过request来触发的
        //request.getRequestDispatcher("main.jsp").forward(servletRequest,servletResponse);
        //request.getRequestDispatcher("main.jsp").include(servletRequest,servletResponse);
        System.out.println("------ FirstFilter end doFilter ------");
    }

    /**
     * 销毁时调用
     */
    @Override
    public void destroy() {
        System.out.println("------ FirstFilter destroy ------");
    }

}
