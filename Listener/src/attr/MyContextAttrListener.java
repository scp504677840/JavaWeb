package attr;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyContextAttrListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- ContextAttr 被添加 ---" + name + " : " + value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- ContextAttr 被移除 ---" + name + " : " + value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- ContextAttr 被替换 ---" + name + " : " + value);
    }

}
