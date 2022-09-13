package personal.ivan.postgresql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintForeignKeys {
    public static void printKeys(Connection connection) {
        ResultSet foreignKeys = null;
        DatabaseMetaData meta = null;
        try {
            meta = connection.getMetaData();
            foreignKeys = meta.getImportedKeys(connection.getCatalog(), null, "table3");
            //connection.close();
            //создаем объект, хранящий название таблиц и столбцов
            KeysInfo keysInfo = new KeysInfo();
            System.out.println("Выводим названия всех внешних ключей и названия конечных и начальных" +
                    "таблиц и столбцов");
            while (foreignKeys.next()) {
                System.out.println(foreignKeys.getString("PKTABLE_NAME"));
                System.out.println(foreignKeys.getString("PKCOLUMN_NAME"));
                System.out.println(foreignKeys.getString("FKTABLE_NAME"));
                System.out.println(foreignKeys.getString("FKCOLUMN_NAME"));
                // заполняем список названиями
                keysInfo.keysDescription.put(foreignKeys.getString("PKTABLE_NAME"),
                        foreignKeys.getString("PKCOLUMN_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
