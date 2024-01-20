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

}