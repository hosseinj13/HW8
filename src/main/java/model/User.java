package model;

public class User {

    private int userId;
    private String name;
    private String username;
    private String email;
    private String password;


    public User() {
    }

    public User(int userId, String name, String username, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
