package service;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;
import exception.UserExistException;
import utils.ServiceUtils;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     *
     * @param user 用户
     * @return 用户注册成功返回true；否则返回false；
     */
    @Override
    public boolean register(User user) throws UserExistException {
        //当用户已存在时
        boolean isExist = userDao.findUser(user.getUsername());
        if (isExist) {
            throw new UserExistException();
        }

        //对密码进行加密
        String password = ServiceUtils.md5(user.getPassword());
        user.setPassword(password);

        return userDao.addUser(user);
    }

    /**
     * 登录
     *
     * @param user 用户
     * @return 登录成功返回User；否则返回NULL；
     */
    @Override
    public User login(User user) {
        String password = ServiceUtils.md5(user.getPassword());
        user.setPassword(password);
        return userDao.findUser(user.getUsername(),user.getPassword());
    }
}
