package two;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import util.SSOCheck;

import javax.servlet.http.HttpServletRequest;

public class TowAction extends ActionSupport {

    private String gotoUrl;

    public String main(){
        //获取HttpServletRequest
        HttpServletRequest request = ServletActionContext.getRequest();
        //当Cookie有效时
        if (SSOCheck.checkCookie(request)){
            return SUCCESS;
        }

        //暂存将要去的URL，登录成功后直接跳转
        setGotoUrl("/two/main.action");

        return LOGIN;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }
}
