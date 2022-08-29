package personal.ivan.postgresql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DTOpattern {
    public static void main(String[] args) {
        String command = null;
        Statement statement = null;
        Connection connection = null;
        DatabaseMetaData meta = null;
        ResultSetMetaData resMeta = null;
        ResultSet foreignKeys = null;
        ResultSet crossRef = null;
        List<DTO_for_testbase_table3> lst = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testbase", "ivan", "ivan");
            statement = connection.createStatement();
            command = "SELECT * FROM table3 ";
            ResultSet res = statement.executeQuery(command);
            meta = connection.getMetaData();
            //возвращает название всех таблиц в БД
            System.out.println("Выводим названия всех таблиц");
            try (ResultSet tables = meta.getTables(null, null, "%", new String[]{"TABLE"})) {
                while (tables.next()) {
                    System.out.println(tables.getString("TABLE_NAME"));
                }
            }
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
            System.out.println("Выводим названия всех объектов таблицы");
            while (res.next()) {
                System.out.println(res.getInt("id3"));
                System.out.println(res.getString("name"));
                System.out.println(res.getString("address"));
                System.out.println();
                //создаем DTO объекты
                DTO_for_testbase_table3 obj = new DTO_for_testbase_table3(res.getInt("id3"),
                        res.getString("name"),
                        res.getString("address"));
                //добавляем их в список
                lst.add(obj);
            }
            for (var o : lst
            ) {
                //здесь можно название test заменить на строку, полученную из foreign keys, чтобы
                //подходило под более обший случай, когда не знаем имя таблицы
                command = "SELECT * FROM test WHERE id=" + o.id;
                statement = connection.createStatement();
                ResultSet r = statement.executeQuery(command);
                r.next();
                o.relatedObjects.add(new DTO_for_testbase_table3(r.getInt("id"),
                        r.getString("name"), r.getString("address")));
            }
            lst = SelectFromTable.select(connection);
            System.out.println("Выводим объекты одной таблицы и сразу же зависящие от них объекты");
            for (var obj1 : lst
            ) {
                System.out.println(obj1.id);
                System.out.println(obj1.name);
                System.out.println(obj1.address);
                for (var obj2 : obj1.relatedObjects
                ) {
                    System.out.println(obj2.id);
                    System.out.println(obj2.name);
                    System.out.println(obj2.address);
                }
                System.out.println();
            }
            //обновляем данные в списке и делаем update в таблицу
            UpdateTable.update(connection, lst);

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
