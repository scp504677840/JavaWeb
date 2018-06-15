import java.util.ArrayList;

public class Users {

    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("tom", "123"));
        users.add(new User("jack", "123"));
        users.add(new User("cher", "123"));
    }

    private Users() {
    }

    public static ArrayList<User> getAll() {
        return users;
    }

}
