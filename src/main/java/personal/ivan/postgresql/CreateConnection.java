package personal.ivan.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static Connection createConnection(String url, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testbase", "ivan", "ivan");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
