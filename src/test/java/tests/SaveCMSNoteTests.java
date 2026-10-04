package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import dataproviders.SaveCMSNoteDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import listeners.AllureAttachments;
import payloads.SaveCMSNotePayload;
import utils.ConfigReader;
import utils.Log;
import utils.SchemaValidatorUtil;
import utils.TestContext;
import utils.TokenManager;

@Epic("Claims API")
@Feature("Save CMS Note")
@Story("Create and Update CMS Notes")
public class SaveCMSNoteTests {

    @Test(
            dataProvider = "saveCMSData",
            dataProviderClass = SaveCMSNoteDataProvider.class
    )
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate SaveCMSNote API for all scenarios")
    public void saveCMSNoteTests(

            String tcId,
            String note,
            Object cmsClaimId,
            Object claimantId,
            Object docketId,
            Object sendNotification,
            int expectedHttpStatus,
            int expectedApiStatus,
            String expectedMessage,
            String expectedErrorMessage)

            throws Exception {

        //System.out.println("Executing : " + tcId);
    	Log.info("Executing Test Case : " + tcId);
    	
        SaveCMSNotePayload payload =
                new SaveCMSNotePayload();

        payload.setNote(note);

        payload.setCMSClaimId(
                String.valueOf(cmsClaimId));

        payload.setClaimantId(
                String.valueOf(claimantId));

        payload.setDocketId(
                String.valueOf(docketId));

        payload.setSendNotification(
                sendNotification);

        ObjectMapper mapper =
                new ObjectMapper();

        String requestBody =
                mapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(payload);
        
        TestContext.tcId.set(tcId);

        TestContext.requestPayload.set(
                requestBody);

        TestContext.expectedResult.set(
                expectedMessage);

        TestContext.httpStatus.set(
                String.valueOf(expectedHttpStatus));

        TestContext.apiStatus.set(
                String.valueOf(expectedApiStatus));
        
        /* Newly added */
        Log.info("Request Body : ");
        Log.info(requestBody);
        /***************/
        
        AllureAttachments.request(requestBody);

        Response response =

                given()
                        .header(
                                "Authorization",
                                "Bearer "
                                        + TokenManager.getToken())
                        .contentType("application/json")
                        .log().all()
                        .body(payload)

                .when()
                	.post(ConfigReader.get("baseUrl")
                        + ConfigReader.get("saveCMSNoteEndpoint"))

                .then()
                        .log().all()
                        .extract()
                        .response();
        
        TestContext.responseBody.set(
                response.asPrettyString());

        TestContext.actualResult.set(
                response.asPrettyString());
        
        TestContext.actualResult.set(
                response.asPrettyString());
        
        /* Newly added Block */
        Log.info(
                "Response Status Code : "
                        + response.statusCode());

        Log.info(
                "Response Body : ");

        Log.info(
                response.asPrettyString());
        /**********************/

        AllureAttachments.response(
                response.asPrettyString());

        validateSchema(
                expectedHttpStatus,
                response);

        validateResponse(
                tcId,
                response,
                expectedHttpStatus,
                expectedApiStatus,
                expectedMessage,
                expectedErrorMessage);
    }

    private void validateSchema(
            int expectedHttpStatus,
            Response response) {

        try {

            if (expectedHttpStatus == 200) {

                SchemaValidatorUtil
                        .validateSuccess(response);

            } else {

                SchemaValidatorUtil
                        .validateError(response);
            }

        } catch (Exception e) {

            System.out.println(
                    "Schema validation skipped : "
                            + e.getMessage());
        }
    }

    private void validateResponse(

            String tcId,
            Response response,
            int expectedHttpStatus,
            int expectedApiStatus,
            String expectedMessage,
            String expectedErrorMessage) {
    	
    	/* Newly added block */
    	Log.info(
    	        tcId
    	                + " Expected HTTP Status : "
    	                + expectedHttpStatus);

    	Log.info(
    	        tcId
    	                + " Actual HTTP Status : "
    	                + response.statusCode());
    	/******************/

        Assert.assertEquals(
                response.statusCode(),
                expectedHttpStatus,
                tcId + " : HTTP Status Validation Failed");

        if (expectedApiStatus != -1) {

            Assert.assertEquals(
                    response.jsonPath()
                            .getInt("statusCode"),
                    expectedApiStatus,
                    tcId + " : API Status Validation Failed");
        }

        if (expectedMessage != null) {

            Assert.assertEquals(
                    response.jsonPath()
                            .getString("message"),
                    expectedMessage,
                    tcId + " : Message Validation Failed");
        }

        if (expectedErrorMessage != null) {

            Assert.assertTrue(
                    response.asString()
                            .contains(
                                    expectedErrorMessage),
                    tcId
                            + " : Expected Error Message Not Found");
        }

        if (expectedHttpStatus == 200
                && expectedApiStatus == 200) {

            Assert.assertNotNull(
                    response.jsonPath()
                            .get("noteId"),
                    tcId
                            + " : noteId should not be null");
        }

        //System.out.println(tcId + " PASSED");
        Log.info(tcId + " PASSED");
    }
}