package dao;

import bean.User;

public interface UserDao {

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 是否添加成功
     */
    boolean addUser(User user);

    /**
     * 查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User findUser(String username, String password);

    /**
     * 查询用户是否存在
     *
     * @param username 用户名
     * @return 用户存在返回true；否则返回false；
     */
    boolean findUser(String username);

}
