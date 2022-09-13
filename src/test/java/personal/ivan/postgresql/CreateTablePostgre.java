package personal.ivan.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablePostgre {
    public static void main(String[] args) {
        String command = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testbase", "ivan", "ivan");
            //command = "Create Table Test(id int primary key, name varchar, address text) ";
            statement = connection.createStatement();
            command = "INSERT INTO test (id, name, address) " +
                    "VALUES ('34', 'ivan', 'russia')";
            statement.executeUpdate(command);
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}