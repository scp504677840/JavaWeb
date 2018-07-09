package main;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * 容器启动时，会将注解@HandlesTypes指定类型【普通类、抽象类、接口】的子类或实现类传递过去。就是下面onStartup方法里面的set集合。
 */
@HandlesTypes(value = {Person.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 应用启动的时候会调用onStartup方法
     *
     * @param set
     * @param servletContext ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        set.forEach(aClass -> {
            System.out.println(aClass);
        });
        //class main.Student
        //class main.Worker
    }
}
