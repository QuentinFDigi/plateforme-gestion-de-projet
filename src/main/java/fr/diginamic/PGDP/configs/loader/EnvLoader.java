package fr.diginamic.PGDP.configs.loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvLoader {
    public static void loadEnv() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(".env");
            properties.load(fis);
            properties.forEach((key, value) -> System.setProperty(key.toString(), value.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
