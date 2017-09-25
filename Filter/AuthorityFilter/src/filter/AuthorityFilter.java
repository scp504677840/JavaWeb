package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthorityFilter extends HttpFilter {

    private ServletContext mContext;
    private Map<String, String> mAuthorityKV;

    @Override
    public void init() throws ServletException {
        mContext = getServletContext();

        String authority = mContext.getInitParameter("Authority");
        String[] authorities = authority.split(",");

        mAuthorityKV = new HashMap<>();

        for (String author : authorities) {
            String[] kv = author.split(":");
            mAuthorityKV.put(kv[0], kv[1]);
        }
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = request.getSession();
        Object authority = session.getAttribute("authority");

        if (authority == null) {
            chain.doFilter(request, response);
            return;
        }

        String[] authorities = authority.toString().split(",");

        //获取servletPath
        String servletPath = request.getServletPath();

        for (String author : authorities) {

            String path = mAuthorityKV.get(author);
            if (servletPath.equals(path)) {
                chain.doFilter(request, response);
                return;
            }

        }

        //重定向无权限界面
        response.sendRedirect(request.getContextPath() + "/no-authority.jsp");

    }
}
