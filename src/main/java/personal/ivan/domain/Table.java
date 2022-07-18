package personal.ivan.domain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Table extends Element {
    private ArrayList<ArrayList<String>> listOfRows = new ArrayList<>();

    public Table(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
