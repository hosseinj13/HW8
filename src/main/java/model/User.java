package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {

    private int userId;
    private String name;
    private String userName;
    private String password;
}
