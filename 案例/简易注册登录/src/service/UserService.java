package service;

import bean.User;
import exception.UserExistException;

public interface UserService {

    /**
     * 注册用户
     *
     * @param user 用户
     * @return 用户注册成功返回true；否则返回false；
     */
    boolean register(User user) throws UserExistException;

    /**
     * 登录
     * @param user 用户
     * @return 登录成功返回User；否则返回NULL；
     */
    User login(User user);

}
