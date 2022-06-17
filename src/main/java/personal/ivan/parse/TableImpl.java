package personal.ivan.parse;

import org.asciidoctor.ast.Cell;
import org.asciidoctor.ast.StructuralNode;
import personal.ivan.GlobalConstants;
import personal.ivan.domain.Link;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableImpl {
    public static personal.ivan.domain.Table ConvertToTable(StructuralNode node) {
        personal.ivan.domain.Table table = new personal.ivan.domain.Table("table");
        table.setProperties(node.getAttributes());
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
