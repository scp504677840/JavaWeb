package file;

import java.util.HashMap;
import java.util.Map;

public class FileUploadProperties {

    private Map<String, String> properties = new HashMap<>();

    private FileUploadProperties() {
    }

    private static FileUploadProperties instance = new FileUploadProperties();

    public static FileUploadProperties getInstance() {
        return instance;
    }

    public void addProperty(String propertyName, String propertyValue) {
        properties.put(propertyName, propertyValue);
    }

    public String getProperty(String propertyName) {
        return properties.get(propertyName);
    }
}
