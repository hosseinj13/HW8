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
}
