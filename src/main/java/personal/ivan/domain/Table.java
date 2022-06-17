package personal.ivan.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Table extends Element {
    private ArrayList<ArrayList<String>> listOfRows = new ArrayList<>();
    public Table(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
