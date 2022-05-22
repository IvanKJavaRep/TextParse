package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import personal.ivan.domain.Document;

import java.util.ArrayList;

public class TableImpl {
    public static void ConvertToTable(Document doc,StructuralNode node)
    {
        Table t = (Table) node;
        personal.ivan.domain.Table table = new personal.ivan.domain.Table("table");

        for (var el : t.getHeader()) {
            ArrayList<String> elements = new ArrayList<>();
            for (var cell : el.getCells()) {
                elements.add(cell.getText());
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
                var document = cell.getInnerDocument();
                if(document!=null) {
                    FindListsRecur.FindLists(document, doc);
                }
            }
            table.listOfRows.add(elements);
        }
        doc.elements.add(table);
    }
}
