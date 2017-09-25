package attr;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttrListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- SessionAttr 被添加 ---" + name + " : " + value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- SessionAttr 被移除 ---" + name + " : " + value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- SessionAttr 被替换 ---" + name + " : " + value);
    }
}
