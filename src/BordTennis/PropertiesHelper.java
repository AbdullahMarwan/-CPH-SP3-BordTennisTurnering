package BordTennis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private static final String PROPERTIES_CONFIG_PATH = "src/BordTennis/resources/config.properties";

    public static Properties retrieveProperties() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(PropertiesHelper.PROPERTIES_CONFIG_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
