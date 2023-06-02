package pro.dagen.config;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
    final static InputStream PROPERTIES_STREAM = Thread.currentThread().getContextClassLoader().getResourceAsStream("dagen.properties");
    @Getter
    Properties properties = new Properties();

    public Config() {
        try {
            properties.load(PROPERTIES_STREAM);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
