package attr;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyRequestAttrListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- RequestAttr 被添加 ---" + name + " : " + value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- RequestAttr 被移除 ---" + name + " : " + value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println("--- RequestAttr 被替换 ---" + name + " : " + value);
    }
}
