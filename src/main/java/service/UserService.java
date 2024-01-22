package service;

import model.User;
import repository.UserRepository;
import utility.EmailValidator;
import utility.PasswordValidator;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    private final UserRepository userRepository;
    private final Scanner scanner = new Scanner(System.in);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signup() throws SQLException {

        System.out.println("Please enter your name:  ");
        String name = scanner.nextLine();
        System.out.println("Please enter your username:  ");
        String username = scanner.nextLine();
        System.out.println("Please enter your email:  ");
        String email = scanner.nextLine();
        if (EmailValidator.isEmailValid(email)) {
            System.out.println("Email address is valid!");
        } else {
            System.out.println("Invalid email address. Please enter a valid email address.");
            return;
        }
        System.out.println("Please enter your password:  ");
        String password = scanner.nextLine();
        if (PasswordValidator.isPasswordValid(password)) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Invalid password. Please follow the password requirements.");
            return;
        }
        if (EmailValidator.isEmailValid(email) & PasswordValidator.isPasswordValid(password)) {
            User user = new User(name, username, email, password);
            userRepository.save(user);
            System.out.println("insert done");
        } else {
            System.out.println("insert invalid!");
        }
    }

    public void signIn() throws SQLException {

        System.out.println("Please enter your username:  ");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:  ");
        String password = scanner.nextLine();

        User user = userRepository.findByUsername(username);
        if (user == null)
            System.out.println("Please signup first");
        else if (!user.getPassword().equals(password))
            System.out.println("Please enter correct password");
        else
            System.out.println("WELCOME " + user.getUserName());
    }
}
