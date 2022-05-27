package personal.ivan.parse;

import org.asciidoctor.ast.List;
import org.asciidoctor.ast.ListItem;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.jruby.ast.impl.ListItemImpl;
import personal.ivan.GlobalConstants;
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
            ArrayList<StructuralNode> g = new ArrayList<>();
            for (var item : ((ListItemImpl) (li)).getBlocks()) {
                g.add(item);
            }
            AsciidocParser.parseAsciidoc(g);
            l1.add(li.getText());
        }
        TxtList l = new TxtList(l1, "list");
        return l;
    }

    public static ArrayList<Link> FindLinks(StructuralNode node) {
        ArrayList<Link> lst = new ArrayList<>();
        List f = (List) node;
        for (var n : f.getItems()
        ) {
            ListItem li = (ListItem) n;
            Pattern pat = Pattern.compile(GlobalConstants.regex);
            Matcher mat = pat.matcher(li.getText());
            while (mat.find()) {
                lst.add(new Link(mat.group()));
            }
        }
        return lst;
    }
}
