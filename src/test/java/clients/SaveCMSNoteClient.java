package clients;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import payloads.SaveCMSNotePayload;

public class SaveCMSNoteClient {

    public static Response saveNote(
            SaveCMSNotePayload payload,
            String token) {

        return

        given()
            .header("Authorization",
                    "Bearer " + token)
            .contentType("application/json")
            .body(payload)

        .when()
            .post("/v1/apiclient/savecmsnote")

        .then()
            .extract()
            .response();
    }
}