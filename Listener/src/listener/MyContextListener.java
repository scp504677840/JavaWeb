package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * --- ServletContext 被创建 ---
 * --- ServletContext 被销毁 ---
 * 具体应用：
 * 1.读取Web应用参数
 * 2.创建数据库连接池
 * 3.创建Spring IOC 容器
 */
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--- ServletContext 被创建 ---" + sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--- ServletContext 被销毁 ---" + sce.getServletContext());
    }

}
