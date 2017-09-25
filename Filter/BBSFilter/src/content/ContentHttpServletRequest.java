package content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ContentHttpServletRequest extends HttpServletRequestWrapper {

    public ContentHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        parameter = parameter.replace("fuck", "***");
        return parameter;
    }
}
