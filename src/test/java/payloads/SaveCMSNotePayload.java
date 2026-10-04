package payloads;

public class SaveCMSNotePayload {

    private String Note;
    private String CMSClaimId;
    private String ClaimantId;
    private String DocketId;
    private Object SendNotification;

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getCMSClaimId() {
        return CMSClaimId;
    }

    public void setCMSClaimId(String CMSClaimId) {
        this.CMSClaimId = CMSClaimId;
    }

    public String getClaimantId() {
        return ClaimantId;
    }

    public void setClaimantId(String claimantId) {
        ClaimantId = claimantId;
    }

    public String getDocketId() {
        return DocketId;
    }

    public void setDocketId(String docketId) {
        DocketId = docketId;
    }

    public Object getSendNotification() {
        return SendNotification;
    }

    public void setSendNotification(Object sendNotification) {
        SendNotification = sendNotification;
    }
}