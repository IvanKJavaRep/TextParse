package personal.ivan.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UpdateTable {
    public static void update(Connection connection, List<DTO_for_testbase_table3> lst) {
        Statement statement = null;
        String command = "UPDATE table3 "
                + "SET address = ? "
                + "WHERE id3 = ?";
        for (var obj : lst
        ) {
            obj.address = "updated address";
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            for (var obj : lst
            ) {
                pstmt.setString(1, obj.address);
                pstmt.setInt(2, obj.id);
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
