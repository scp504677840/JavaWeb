package two;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class TowAction extends ActionSupport {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录URL
     * http://two.com:8080/sso/doLogin.action
     */
    private String loginUrl;

    /**
     * 暂存URL
     * http://one.com:8080/one/main.action
     */
    private String gotoUrl;

    /**
     * 隐藏的URL，目的是通知旗下各网站自行存储cookie到自己的域名底下。
     */
    private List<String> hiddenUrl;

    public String main() {

        //暂存将要去的地址，登录成功后直接跳转过去
        setGotoUrl("http://two.com:8080/two/main.action");

        //登录URL
        setLoginUrl("http://two.com:8080/two/doLogin.action");

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

        //组装cookie参数
        Map<String, String> param = new HashMap<>();
        param.put("cookieName", cookie.getName());
        param.put("cookieValue", cookie.getValue());

        //远程校验cookie是否合法
        boolean isCookieSuccess = Tool.doCheckCookie("http://check.com:8080/sso/checkCookie.action", param);

        //当cookie校验成功时
        if (isCookieSuccess) {
            return SUCCESS;
        }

        return LOGIN;
    }

    /**
     * 登录
     *
     * @return
     */
    public String doLogin() {

        //组装URL参数
        Map<String, String> param = new HashMap<>();
        param.put("username", getUsername());
        param.put("password", getPassword());

        //校验登录是否成功
        boolean isLogin = one.Tool.doCheckCookie("http://check.com:8080/sso/doLogin.action", param);
        //当登录成功时
        if (isLogin) {
            //通知旗下所有需要快捷登录的网站自行添加Cookie
            hiddenUrl=new ArrayList<>();
            hiddenUrl.add("http://one.com:8080/one/addCookie.action");
            hiddenUrl.add("http://two.com:8080/two/addCookie.action");
            return SUCCESS;
        }
        //当登录失败时
        return LOGIN;
    }

    /**
     * 添加cookie
     * 因为check.com没办法给one.com和two.com设置cookie，所有他们只能自己给自己设置cookie。
     *
     * @return
     */
    public String addCookie() {

        //新建cookie
        Cookie cookie = new Cookie("ssocookie", "sso");
        //设置域名顶级目录
        cookie.setPath("/");

        //获取HttpServletResponse
        HttpServletResponse response = ServletActionContext.getResponse();
        //添加cookie
        response.addCookie(cookie);

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

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public List<String> getHiddenUrl() {
        return hiddenUrl;
    }

    public void setHiddenUrl(List<String> hiddenUrl) {
        this.hiddenUrl = hiddenUrl;
    }
}
