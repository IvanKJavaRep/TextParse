package personal.ivan.postgresql;

import java.sql.*;

public class InsertValues {
    public static void main(String[] args) {
        String command = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testbase", "ivan", "ivan");

            command = "INSERT INTO test (id, name, address) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(command);

            for (int i = 0; i < 5; i++) {
                ps.setInt(1, i + 20);
                ps.setString(2, "v" + i);
                ps.setString(3, "vv" + i);
                ps.addBatch();
            }
            ps.executeBatch();
            connection.close();

        } catch (SQLException e) {
            e.getErrorCode();
            System.out.println("Connection failure.");

        }
    }
}
