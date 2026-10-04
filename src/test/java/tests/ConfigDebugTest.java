package tests;

import org.testng.annotations.Test;
import utils.ConfigReader;

public class ConfigDebugTest {

    @Test
    public void verifyConfig() {

        System.out.println(
                "baseUrl=[" +
                        ConfigReader.get("baseUrl")
                        + "]");

        System.out.println(
                "authenticateEndpoint=[" +
                        ConfigReader.get(
                                "authenticateEndpoint")
                        + "]");

        System.out.println(
                "clientId=[" +
                        ConfigReader.get("clientId")
                        + "]");

        System.out.println(
                "clientSecret Length="
                        + ConfigReader
                        .get("clientSecret")
                        .length());
    }
}