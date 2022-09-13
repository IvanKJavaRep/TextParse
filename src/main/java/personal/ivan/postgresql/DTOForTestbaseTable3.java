package personal.ivan.postgresql;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class DTOForTestbaseTable3 {
    int id;
    String name;
    String address;
    String somethingNew;
    List<DTOForTestbaseTable3> relatedObjects = new ArrayList<>();

    public DTOForTestbaseTable3(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
