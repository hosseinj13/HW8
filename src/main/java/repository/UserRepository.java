package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(User user) throws SQLException {

        String addUser = "INSERT INTO maktab.hw8.users (name, username, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        int resultSet = preparedStatement.executeUpdate();
    }


    public User findByUsername(String username) throws SQLException {

        String findUser = "SELECT * FROM maktab.hw8.users WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String name = resultSet.getString("name");
            String fetchUsername = resultSet.getString("username");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            User user = new User(name, fetchUsername, email, password);
            return user;
        } else
            return null;
    }


   /* public boolean userUniqe(String username) throws SQLException {

        String sql = "select username from users where " +
                "exists(select username from users where username = ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }*/


}
