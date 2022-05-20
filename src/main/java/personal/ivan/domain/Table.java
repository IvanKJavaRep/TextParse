package personal.ivan.domain;

import java.util.ArrayList;

public class Table extends Element {
    public ArrayList<ArrayList<String>> listOfRows = new ArrayList<>();
    public Table(String text) {
        super(text);
    }

    @Override
    public void printContent() {

    }
}
