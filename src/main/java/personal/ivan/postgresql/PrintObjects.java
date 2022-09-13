package personal.ivan.postgresql;

import java.util.List;

public class PrintObjects {
    public static void printObjects(List<DTOForTestbaseTable3> lst) {
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
    }
}
