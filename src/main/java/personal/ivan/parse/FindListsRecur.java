package personal.ivan.parse;

import org.asciidoctor.ast.Document;
import personal.ivan.read.AsciidocREadFile;

public class FindListsRecur {
    public static void FindLists(Document d, personal.ivan.domain.Document mydoc)
    {
        //((ListItem)((List)((CellImpl)((RowImpl)t.getBody().get(8)).getCells().get(4)).getInnerDocument().getBlocks().get(1)).getItems().get(3)).getText();
        //ArrayList<StructuralNode> lst = (ArrayList<StructuralNode>) ((CellImpl)((RowImpl)t.getBody().get(8)).getCells().get(4)).getInnerDocument().getBlocks();
        if(d.getBlocks().size()>0) {
            AsciidocREadFile reader = new AsciidocREadFile();
            AsciidocParser parser = new AsciidocParser();
            reader.GetAllBlocks(d);
            parser.parseAsciidoc(reader.lst, mydoc);
        }
    }
}
