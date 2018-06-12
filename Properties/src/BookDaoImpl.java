import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BookDaoImpl implements BookDao {

    /**
     * 配置
     */
    private static Properties dbConfig = new Properties();

    // 静态代码块：只做一次初始化
    static {
        try {
            // 类加载器去获取资源，但有一个问题，资源文件不能太大。
            InputStream in = BookDaoImpl.class.getClassLoader().getResourceAsStream("db.properties");
            dbConfig.load(in);
        } catch (IOException e) {
            // 抛一个错误
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 更新书籍
     *
     * @param book 书籍
     * @return 是否更新成功
     */
    @Override
    public boolean updateBook(Book book) {
        System.out.println("url:" + dbConfig.getProperty("url"));
        return true;
    }
}
