package common;

import java.io.FileReader;
import java.io.Reader;
import java.security.Key;
import java.util.Properties;

public class Configuration {
    String configFilePath;
    public Configuration(String configFilePathInput) {
        this.configFilePath = configFilePathInput;
    }

    public String getConfigValueByKey(String key) {
        String value = "";
        Properties config  = new Properties();
        Reader reader;
        try {
            reader = new FileReader(configFilePath);
            config.load(reader);
            value = config.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
