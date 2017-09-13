package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class SSOCheck {

    /**
     * 模拟用户名
     */
    private static final String USERNAME = "scp";

    /**
     * 模拟密码
     */
    private static final String PASSWORD = "123";

    /**
     * 模拟登录，用户名、密码校验过程
     * 注意：
     * 校验用户名、密码应该从数据库取得数据与之校验，
     * 同时从客户端传过来的密码应该是加密过的，服务器需要解密；
     * 因为我们只是简单演示，所以在这里简写，真实操作按照上述描述进行即可。
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户名、密码是否合法
     */
    public static boolean checkLogin(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    /**
     * 校验Cookie
     *
     * @param request 请求
     * @return Cookie是否合法
     */
    public static boolean checkCookie(HttpServletRequest request) {
        return Arrays.stream(request.getCookies())
                .anyMatch(cookie -> "ssocookie".equals(cookie.getName()) && "sso".equals(cookie.getValue()));
    }

}
