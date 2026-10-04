package tests;

import org.testng.annotations.Test;
import utils.TokenManager;

public class TokenTest {

    @Test
    public void verifyTokenGeneration() {

        String token = TokenManager.getToken();

        System.out.println("Actual Token = " + token);
    }
}