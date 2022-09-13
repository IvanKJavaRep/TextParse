package personal.ivan.postgresql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class RecursiveSearch {
    //пытался создать рекурсию для набора из n таблиц с n foreign keys, но пока трудно
    public static void recursiveSearch(DTOForTestbaseTable3 obj, String tableName, Connection connection) {

        DatabaseMetaData meta = null;
        try {
            meta = connection.getMetaData();
            var foreignKeys = meta.getImportedKeys(connection.getCatalog(), null, "table3");
            while (foreignKeys.next()) {
                String t = foreignKeys.getString("PKTABLE_NAME");
                String c = foreignKeys.getString("PKCOLUMN_NAME");
                //var command = "SELECT FROM" + t "WHERE" + c +"="+;
                //PreparedStatement ps = connection.prepareStatement(command);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
