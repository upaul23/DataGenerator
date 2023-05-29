package pro.dagen.config;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Config {
    final static String PROPERTIES_PATH = Thread.currentThread().getContextClassLoader().getResource("app.properties").getPath();
    @Getter
    Properties properties = new Properties();

    public Config() {
        try {
            properties.load(new FileInputStream(PROPERTIES_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
