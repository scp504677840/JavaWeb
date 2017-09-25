package login;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private ServletContext mContext;
    private List<String> mUsers;

    @Override
    public void init() throws ServletException {
        mContext = getServletContext();
        String users = mContext.getInitParameter("Users");
        mUsers = Arrays.asList(users.split(","));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        if (mUsers.contains(username)) {
            req.getSession().setAttribute("username",username);
            resp.sendRedirect(req.getContextPath() + "/index");
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/login.jsp");

    }

}
