package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Shareholder {
    private int shareholderId;
    private String shareholderName;
    private String phoneNumber;
    private String nationalCode;

    public Shareholder(String shareholderName, String phoneNumber, String nationalCode) {
        this.shareholderName = shareholderName;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }
}