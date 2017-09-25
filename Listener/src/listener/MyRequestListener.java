package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("--- Request 被创建 ---" + sre.getServletRequest());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("--- Request 被销毁 ---" + sre.getServletRequest());
    }
}
