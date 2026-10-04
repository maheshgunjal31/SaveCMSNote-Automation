package utils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidatorUtil {

    public static void validateSuccess(io.restassured.response.Response response) {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(
                        "schemas/success-response-schema.json"));
    }

    public static void validateError(io.restassured.response.Response response) {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(
                        "schemas/error-response-schema.json"));
    }
}