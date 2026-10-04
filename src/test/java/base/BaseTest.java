package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;

public class BaseTest {

    @BeforeSuite
    public void setup() {

        RestAssured.baseURI =
                ConfigReader.get("baseUrl");
    }
}