package sso;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import util.SSOCheck;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 不同域SSO演示一定要记得改 hosts 文件！！！
 * # 演示本机不同域名地址
 * 127.0.0.1	localhost
 * 127.0.0.1	one.com
 * 127.0.0.1	two.com
 * 127.0.0.1	check.com
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
     * 登录的URL
     * http://check.com:8080/sso/doLogin.action
     */
    //private String loginUrl;

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
    public String doLogin() throws MalformedURLException {
        try {
            //校验用户名、密码
            boolean isLogin = SSOCheck.checkLogin(getUsername(), getPassword());

            //获取HttpServletResponse
            HttpServletResponse response = ServletActionContext.getResponse();
            //获取PrintWriter
            PrintWriter writer = response.getWriter();
            //输出登录结果
            writer.print(isLogin);
            //关闭writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
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
