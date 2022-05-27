package personal.ivan.parse;

import org.asciidoctor.ast.Cell;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import personal.ivan.GlobalConstants;
import personal.ivan.domain.Link;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableImpl {
    public static personal.ivan.domain.Table ConvertToTable(StructuralNode node) {
        Table t = (Table) node;
        personal.ivan.domain.Table table = new personal.ivan.domain.Table("table");

        for (var el : t.getHeader()) {
            ArrayList<String> elements = new ArrayList<>();
            for (var cell : el.getCells()) {
                elements.add(cell.getText());
                findLinks(cell);
                var document = cell.getInnerDocument();
                if (document != null) {
                    FindListsRecur.FindLists(document);
                }
            }
            table.listOfRows.add(elements);
        }
        for (var el : t.getBody()) {
            ArrayList<String> elements = new ArrayList<>();
            for (var cell : el.getCells()) {
                elements.add(cell.getText());
                findLinks(cell);
                var document = cell.getInnerDocument();
                if (document != null) {
                    FindListsRecur.FindLists(document);
                }
            }
            table.listOfRows.add(elements);
        }
        return table;
    }

    public static ArrayList<Link> findLinks(Cell cell) {
        // ищет url в тексте с доменами на любом языке.
        ArrayList<Link> lst = new ArrayList<>();
        Pattern pat = Pattern.compile(GlobalConstants.regex);
        Matcher mat = pat.matcher(cell.getText());
        while (mat.find()) {
            lst.add(new Link(mat.group()));
        }
        return lst;
    }
}
