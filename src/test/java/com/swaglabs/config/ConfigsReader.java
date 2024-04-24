package com.swaglabs.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
    private static Properties prop;
    public static void readProperties(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {

        }
    }

    public static String getProperty(String key) {
        if (prop != null) {
            return prop.getProperty(key);
        } else {
            return null;
        }
    }
}
