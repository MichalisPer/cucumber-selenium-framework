package com.personal.mp.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertiesFilePath = "src/test/resources/config.properties";

    public ConfigFileReader() {
        try (BufferedReader br = new BufferedReader(new FileReader(propertiesFilePath))) {
            properties = new Properties();
            properties.load(br);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not find properties file");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getApplicationUrl() {
        return properties.getProperty("applicationUrl");
    }

    public String getSeleniumGridHubUrl() {
        return properties.getProperty("seleniumGridHubUrl");
    }
}
