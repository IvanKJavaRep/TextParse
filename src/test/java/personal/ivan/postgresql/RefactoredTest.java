package personal.ivan.postgresql;

import java.sql.Connection;

public class RefactoredTest {
    public static void main(String[] args) {
        Connection c = CreateConnection.createConnection("jdbc:postgresql://localhost:5432/testbase", "ivan", "ivan");
        var lst = SelectFromTable.select(c);
        PrintForeignKeys.printKeys(c);
        PrintObjects.printObjects(lst);
        UpdateTable.update(c, lst);
    }
}
