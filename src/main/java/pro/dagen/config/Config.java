package pro.dagen.config;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
    InputStream PROPERTIES_STREAM;
    @Getter
    Properties properties;

    public Config() {
        properties = new Properties();
        PROPERTIES_STREAM = Thread.currentThread().getContextClassLoader().getResourceAsStream("dagen.properties");
        try {
            properties.load(PROPERTIES_STREAM);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
