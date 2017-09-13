package sso;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import util.SSOCheck;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 同父域SSO演示一定要记得改 hosts 文件！！！
 * # 演示本机不同域名地址
 * 127.0.0.1	localhost
 * 127.0.0.1	one.x.com
 * 127.0.0.1	two.x.com
 * 127.0.0.1	check.x.com
 */
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
     * Cookie名称
     */
    private String cookieName;

    /**
     * Cookie值
     */
    private String cookieValue;

    /**
     * 登录
     * 1.校验用户名、密码是否合法
     *
     * @return
     */
    public String doLogin() {

        //校验用户名、密码
        boolean isLogin = SSOCheck.checkLogin(getUsername(), getPassword());

        //当登录成功时
        if (isLogin) {
            //真实应用cookie存储的值应该加密，这里只做演示，故省略。
            Cookie cookie = new Cookie("ssocookie", "sso");
            //设置域名；其中x.com表示设置某个网站的父域名，在父域名下的所有子域名都可以看到这个Cookie。
            //在Tomcat9中cookie.setDomain(xxx.com)必须这样写。
            //具体命名规则请看 http://blog.csdn.net/li_cheng_liang/article/details/54603269
            cookie.setDomain("x.com");
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

    /**
     * 校验cookie
     *
     * @return
     */
    public String checkCookie() {
        try {
            //获取HttpServletResponse
            HttpServletResponse response = ServletActionContext.getResponse();
            //获取PrintWriter
            PrintWriter writer = response.getWriter();
            //输出校验cookie结果
            writer.print(SSOCheck.checkCookie(cookieName, cookieValue));
            //关闭writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getCookieValue() {
        return cookieValue;
    }

    public void setCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
    }
}
