package personal.ivan.parse;

import org.asciidoctor.ast.List;
import org.asciidoctor.ast.ListItem;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import org.asciidoctor.jruby.ast.impl.CellImpl;
import org.asciidoctor.jruby.ast.impl.RowImpl;

import java.util.ArrayList;

public class FindListsRecur {
    public void FindLists(Table t)
    {
        //((ListItem)((List)((CellImpl)((RowImpl)t.getBody().get(8)).getCells().get(4)).getInnerDocument().getBlocks().get(1)).getItems().get(3)).getText();
        ArrayList<StructuralNode> lst =((ListItem)((List)((CellImpl)((RowImpl)t.getBody().get(8)).getCells().get(4)).getInnerDocument().getBlocks();

    }
}
