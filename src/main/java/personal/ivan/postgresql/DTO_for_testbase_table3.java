package personal.ivan.postgresql;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class DTO_for_testbase_table3 {
    int id;
    String name;
    String address;
    String somethingNew;
    List<DTO_for_testbase_table3> relatedObjects = new ArrayList<>();

    public DTO_for_testbase_table3(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
