package personal.ivan.parse;

import org.asciidoctor.ast.Cell;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import personal.ivan.domain.Document;
import personal.ivan.domain.Link;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableImpl {
    public static void ConvertToTable(Document doc,StructuralNode node)
    {
        Table t = (Table) node;
        personal.ivan.domain.Table table = new personal.ivan.domain.Table("table");

        for (var el : t.getHeader()) {
            ArrayList<String> elements = new ArrayList<>();
            for (var cell : el.getCells()) {
                elements.add(cell.getText());
                findLinks(doc, cell);
                var document = cell.getInnerDocument();
                if(document!=null) {
                    FindListsRecur.FindLists(document, doc);
                }
            }
            table.listOfRows.add(elements);
        }
        for (var el : t.getBody()) {
            ArrayList<String> elements = new ArrayList<>();
            for (var cell : el.getCells()) {
                elements.add(cell.getText());
                findLinks(doc, cell);
                var document = cell.getInnerDocument();
                if(document!=null) {
                    FindListsRecur.FindLists(document, doc);
                }
            }
            table.listOfRows.add(elements);
        }
        doc.elements.add(table);
    }
    public static void findLinks(Document doc, Cell cell) {
        // ищет url в тексте с доменами на любом языке.
        String regex = "\\b(https?|ftp|file)://[-\\p{L}0-9+&@#/%?=~_|!:,.;]*[-\\p{L}0-9+&@#/%=~_|]";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(cell.getText());
        while (mat.find()) {
            doc.elements.add(new Link(mat.group()));
        }
    }
}
