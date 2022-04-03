package com.pecodesoftware.pecode_test_task.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    Properties properties = new Properties();
    FileInputStream fis;
    String url;

    public String getProperty(String propertyName) {
        try {
            fis = new FileInputStream("src/main/java/com/pecodesoftware/pecode_test_task/config/config.properties");
            properties.load(fis);
            url = properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}