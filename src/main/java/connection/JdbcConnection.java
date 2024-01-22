package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "h9311240246N");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JdbcConnection() {
    }

    static public Connection getConnection() {
        return connection;
    }
}