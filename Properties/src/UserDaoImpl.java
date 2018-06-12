import java.io.*;
import java.net.URL;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @Override
    public User getUser() {
        // getClassLoader().getResourceAsStream方式获取资源，这种方式不会动态加载更新后但配置文件。
        /*try {
            InputStream in = UserDaoImpl.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            String url = properties.getProperty("url");
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // getClassLoader().getResource方式获取资源，这种方式可以动态加载更新后但配置文件。
        // 但是实验表明UserDaoImpl.class.getClassLoader().getResource("db.properties").getPath();
        // 这种方式不行，但是直接写配置文件完整绝对路径是可以的。
        try {
            // 方式一：测试结果不行
            /*String path = UserDaoImpl.class.getClassLoader().getResource("db.properties").getPath();
            System.out.println("path:" + path);
            FileInputStream fin = new FileInputStream(path);*/

            // 方式二：测试结果可以
            FileInputStream fin = new FileInputStream("/Users/scp/Documents/Workspace/Java/JLab/src/db.properties");
            Properties properties = new Properties();
            properties.load(fin);

            String url = properties.getProperty("url");
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
