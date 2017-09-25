package session;

import javax.servlet.http.*;
import java.io.Serializable;

public class User implements Serializable, HttpSessionBindingListener, HttpSessionActivationListener {

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("--- 从 Session 绑定 ---" + name + " : " + value);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        System.out.println("--- 从 Session 解绑 ---" + name + " : " + value);
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("--- Session 从内存中写到硬盘上 ---" + session);
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("--- Session 从硬盘中读取到出来 ---" + session);
    }
}
