package personal.ivan.parse;

import org.asciidoctor.ast.List;
import org.asciidoctor.ast.ListItem;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.jruby.ast.impl.ListItemImpl;
import personal.ivan.domain.Document;
import personal.ivan.domain.TxtList;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class OListImpl {
    public static void convertToOlist(StructuralNode node, Document doc) throws MalformedURLException {
        List f = (List) node;
        ArrayList<String> l1 = new ArrayList<>();
        for (var n : f.getItems()
        ) {
            ListItem li = (ListItem) n;
            ArrayList<StructuralNode> g = (ArrayList<StructuralNode>) ((ListItemImpl)(li)).getBlocks();
            AsciidocParser.parseAsciidoc(g);
            l1.add(li.getText());
        }
        TxtList l = new TxtList(l1, "list");
        doc.elements.add(l);
    }
}
