package personal.ivan.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectFromTable {
    public static List<DTO_for_testbase_table3> select(Connection connection) {
        Statement statement;
        List<DTO_for_testbase_table3> lst = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String command = "SELECT * FROM table3 ";
            ResultSet res = statement.executeQuery(command);
            while (res.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lst;

    }
}
