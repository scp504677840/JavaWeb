package one;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class OneAction extends ActionSupport {

    private String gotoUrl;

    public String main() {

        //暂存将要去的地址，登录成功后直接跳转过去
        setGotoUrl("http://one.x.com:8080/one/main.action");

        //获取HttpServletRequest
        HttpServletRequest request = ServletActionContext.getRequest();

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return LOGIN;
        }

        Optional<Cookie> first = Arrays.stream(cookies).filter(cookie -> "ssocookie".equals(cookie.getName())).findFirst();
        Cookie cookie = first.orElse(null);
        if (cookie == null) {
            return LOGIN;
        }

        //远程校验cookie是否合法
        boolean isCookieSuccess = Tool.doCheckCookie("http://check.x.com:8080/sso/checkCookie.action", cookie.getName(), cookie.getValue());
        //当cookie校验成功时
        if (isCookieSuccess) {
            return SUCCESS;
        }

        return LOGIN;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }
}
