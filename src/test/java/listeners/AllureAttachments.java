package listeners;

import io.qameta.allure.Attachment;

public class AllureAttachments {

    @Attachment(
            value = "Request",
            type = "application/json")
    public static String request(
            String request) {

        return request;
    }

    @Attachment(
            value = "Response",
            type = "application/json")
    public static String response(
            String response) {

        return response;
    }
}