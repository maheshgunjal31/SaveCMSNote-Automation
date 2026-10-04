package model;

public class SaveCMSNoteTestData {

    private String tcId;
    private String note;
    private Object cmsClaimId;
    private Object claimantId;
    private Object docketId;
    private Object sendNotification;

    private int expectedHttpStatus;
    private int expectedApiStatus;

    private String expectedMessage;
    private String expectedErrorMessage;

    public void SaveCMSNoteTests(
            String tcId,
            String note,
            Object cmsClaimId,
            Object claimantId,
            Object docketId,
            Object sendNotification,
            int expectedHttpStatus,
            int expectedApiStatus,
            String expectedMessage,
            String expectedErrorMessage) {

        this.tcId = tcId;
        this.note = note;
        this.cmsClaimId = cmsClaimId;
        this.claimantId = claimantId;
        this.docketId = docketId;
        this.sendNotification = sendNotification;
        this.expectedHttpStatus = expectedHttpStatus;
        this.expectedApiStatus = expectedApiStatus;
        this.expectedMessage = expectedMessage;
        this.expectedErrorMessage = expectedErrorMessage;
    }

    public String getTcId() {
        return tcId;
    }

    public String getNote() {
        return note;
    }

    public Object getCmsClaimId() {
        return cmsClaimId;
    }

    public Object getClaimantId() {
        return claimantId;
    }

    public Object getDocketId() {
        return docketId;
    }

    public Object getSendNotification() {
        return sendNotification;
    }

    public int getExpectedHttpStatus() {
        return expectedHttpStatus;
    }

    public int getExpectedApiStatus() {
        return expectedApiStatus;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }

    public String getExpectedErrorMessage() {
        return expectedErrorMessage;
    }
}