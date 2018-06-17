package dao;

import bean.User;
import utils.DaoUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 是否添加成功
     */
    @Override
    public boolean addUser(User user) {
        return DaoUtils.addUser(user);
    }

    /**
     * 查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    @Override
    public User findUser(String username, String password) {
        List<User> users = DaoUtils.getAll();
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password))
                .findFirst()
                .orElse(null);
    }

    /**
     * 查询用户是否存在
     *
     * @param username 用户名
     * @return 用户存在返回true；否则返回false；
     */
    @Override
    public boolean findUser(String username) {
        return DaoUtils.getAll().stream().anyMatch(user -> user.getUsername().equalsIgnoreCase(username));
    }
}
