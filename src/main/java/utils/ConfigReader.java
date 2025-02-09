package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static String environment;

    static {
        loadProperties();
        setEnvironment();
    }

    private static void loadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    private static void setEnvironment() {
        environment = System.getenv("RUN_ENV"); // Fetch from CircleCI or system environment
        if (environment == null || environment.isEmpty()) {
            environment = properties.getProperty("environment", "local"); // Default to local
        }
        System.out.println("Environment set to: " + environment);
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseURL_" + environment, "http://localhost"); // Default local URL
    }

    public static String getEnvironment() {
        return environment;
    }
}
