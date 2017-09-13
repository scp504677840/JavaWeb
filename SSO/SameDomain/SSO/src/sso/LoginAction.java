package sso;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import util.SSOCheck;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends ActionSupport {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 跳转的URL
     */
    private String gotoUrl;

    /**
     * 登录
     * 1.校验用户名、密码是否合法
     * @return
     */
    public String doLogin(){

        //校验用户名、密码
        boolean isLogin = SSOCheck.checkLogin(getUsername(), getPassword());

        //当登录成功时
        if (isLogin){
            //真实应用cookie存储的值应该加密，这里只做演示，故省略。
            Cookie cookie = new Cookie("ssocookie", "sso");
            //设置域名顶级路径，这样的话该域名下所有应用都可以访问到。
            cookie.setPath("/");
            //获取HttpServletResponse
            HttpServletResponse response = ServletActionContext.getResponse();
            //添加Cookie
            response.addCookie(cookie);
            //返回成功
            return SUCCESS;
        }

        //返回失败，我们不做处理
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }
}
