package file;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class FileUploadListener implements ServletContextListener {

    public FileUploadListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {

            InputStream in = getClass().getResourceAsStream("upload.properties");

            Properties properties = new Properties();
            properties.load(in);

            FileUploadProperties fileUploadProperties = FileUploadProperties.getInstance();

            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                fileUploadProperties.addProperty(key,value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
