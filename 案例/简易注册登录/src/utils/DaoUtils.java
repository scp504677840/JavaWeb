package utils;

import bean.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class DaoUtils {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("tom", "123456", "123@163.com", new Date(), "Mr_tom"));
    }

    /**
     * 获取全部用户
     *
     * @return 全部用户
     */
    public static List<User> getAll() {
        return users;
    }

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 是否添加成功
     */
    public static boolean addUser(User user) {
        for (User item : users) {
            if (item.getUsername().equalsIgnoreCase(user.getUsername())) {
                return false;
            }
        }
        return users.add(user);
    }

}
