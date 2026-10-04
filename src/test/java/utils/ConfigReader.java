package utils;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties prop =
            new Properties();

    static {

        try {

            InputStream inputStream =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream(
                                    "config.properties");

            if (inputStream == null) {

                throw new RuntimeException(
                        "config.properties not found");
            }

            prop.load(inputStream);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to load configuration",
                    e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {

        String value =
                prop.getProperty(key);

        if (value == null) {

            throw new RuntimeException(
                    "Missing configuration key : "
                            + key);
        }

        return value
                .trim()
                .replace("\"", "");
    }
}