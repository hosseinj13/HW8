package model;

public class Shareholder {
    private int shareholderId;
    private String shareholderName;
    private String phoneNumber;
    private String nationalCode;

    public Shareholder() {
    }

    public Shareholder(int shareholderId, String shareholderName, String phoneNumber, String nationalCode) {
        this.shareholderId = shareholderId;
        this.shareholderName = shareholderName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public int getShareholderId() {
        return shareholderId;
    }

    public void setShareholderId(int shareholderId) {
        this.shareholderId = shareholderId;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}