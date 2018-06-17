package bean;

import exception.UserDateException;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.util.Date;

public class User {

    private String username;
    private String password;
    private String email;
    private Date birthday;
    private String nikeName;

    public User() {
    }

    public User(String username, String password, String email, Date birthday, String nikeName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.nikeName = nikeName;
    }

    public boolean va() throws UserDateException {
        try {
            String date = "2018-06-17";
            DateLocaleConverter dlc = new DateLocaleConverter();
            Date convert = (Date) dlc.convert("2018-06-30", "yyyy-MM-dd");
            System.out.println(convert);
        } catch (ConversionException e) {
            throw new UserDateException();
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
}
