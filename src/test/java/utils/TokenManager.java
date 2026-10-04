package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class TokenManager {

    private static String token;

    private TokenManager() {
    }

    public static String getToken() {

        if (token != null && !token.isBlank()) {
            return token;
        }

        String authUrl =
                ConfigReader.get("baseUrl")
                + ConfigReader.get("authenticateEndpoint");

        System.out.println("==================================");
        System.out.println("Authentication Started");
        System.out.println("URL : " + authUrl);
        System.out.println("ClientID : "
                + ConfigReader.get("clientId"));
        System.out.println("==================================");

        Response response =

                given()
                        .header(
                                "ClientID",
                                ConfigReader.get("clientId"))

                        .header(
                                "ClientSecret",
                                ConfigReader.get("clientSecret"))

                        .header(
                                "Accept",
                                "application/json")

                        .header(
                                "Content-Type",
                                "application/json")

                        .log().all()

                .when()
                        .get(authUrl)

                .then()
                        .extract()
                        .response();

        System.out.println(
                "Response Body : "
                        + response.asString());

        System.out.println(
                "Status Code : "
                        + response.statusCode());

        if (response.statusCode() != 200) {

            throw new RuntimeException(
                    "Authentication Failed. "
                            + "StatusCode="
                            + response.statusCode()
                            + " Response="
                            + response.asString());
        }

        //token = response.asString().trim();
        token = response.asString()
        	    .replace("\"", "")
        	    .trim();

        if (token == null || token.isBlank()) {

            throw new RuntimeException(
                    "Token is empty.");
        }

        System.out.println(
                "Token Generated Successfully");

        System.out.println(
                "Token Preview : "
                        + token.substring(
                                0,
                                Math.min(20,
                                        token.length()))
                        + "...");

        return token;
    }

    public static void resetToken() {

        token = null;
    }
}