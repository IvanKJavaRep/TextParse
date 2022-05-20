package personal.ivan.parse;

import org.asciidoctor.ast.List;
import org.asciidoctor.ast.ListItem;
import org.asciidoctor.ast.StructuralNode;
import personal.ivan.domain.Document;
import personal.ivan.domain.Link;
import personal.ivan.domain.TxtList;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UListImpl {
    public static TxtList ConvertToTxtList(StructuralNode node) {
        List f = (List) node;
        ArrayList<String> l1 = new ArrayList<>();
        for (var n : f.getItems()
        ) {
            ListItem li = (ListItem) n;
            l1.add(li.getText());
        }
        TxtList l = new TxtList(l1, "list");
        return l;
    }

    public static void FindLinks(Document doc, StructuralNode node) {
        // ищет url в тексте с доменами на любом языке.
        String regex = "\\b(https?|ftp|file)://[-\\p{L}0-9+&@#/%?=~_|!:,.;]*[-\\p{L}0-9+&@#/%=~_|]";
        List f = (List) node;
        for (var n : f.getItems()
        ) {
            ListItem li = (ListItem) n;
            Pattern pat = Pattern.compile(regex);
            Matcher mat = pat.matcher(li.getText());
            while (mat.find()) {
                doc.elements.add(new Link(mat.group()));
            }
        }
    }
}
