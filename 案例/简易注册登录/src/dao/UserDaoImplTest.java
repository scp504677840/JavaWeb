package dao;

import bean.User;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.jupiter.api.Test;
import utils.ServiceUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    @Test
    void addUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User("tom", "123456", "123@163.com", new Date(), "Mr_tom");
        assertFalse(userDao.addUser(user));
    }

    @Test
    void findUser() {
        /*UserDaoImpl userDao = new UserDaoImpl();
        assertTrue(userDao.findUser("tom"));*/
    }

    @Test
    void findUser1() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findUser("tom", "123456");
        assertTrue(user.getUsername().equalsIgnoreCase("tom"));
    }
}