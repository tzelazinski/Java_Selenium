package utilities;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Class used to manipulate properties file contents.
 */
public class PropertiesOperations {

    static Properties prop = new Properties();

    /**
     * Reads property value from properties file given property name.
     *
     * @param key parameter name to extract from properties file
     * @return value parameter value
     */
    public static String getPropertyValueByKey(String key) throws Exception {
        String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        FileInputStream fis = new FileInputStream(propFilePath);
        prop.load(fis);

        String value = prop.get(key).toString();

        if (StringUtils.isEmpty(value)) {
            throw new Exception("Value for " + key + " is not specified in properties file.");
        }

        return value;
    }
}
