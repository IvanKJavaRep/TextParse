package personal.ivan.parse;

import org.asciidoctor.ast.List;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import personal.ivan.domain.Document;

import java.io.FileInputStream;
import java.util.ArrayList;

public class AsciidocParser implements IParse {


    public void parseAsciidoc(ArrayList<StructuralNode> lst, Document d) {
        for (var node : lst
        ) {
            //System.out.println(node.getNodeName());
            if (node.getContext() == "paragraph") {
                ParagraphImpl.ConvertToParagraph(d, node);
            } else if (node instanceof List) {
                d.elements.add(UListImpl.ConvertToTxtList(node));
                UListImpl.FindLinks(d, node);
            } else if (node instanceof Table) {
                TableImpl.ConvertToTable(d, node);
            } else if (node.getNodeName().equals("listing")) {
                ListingImpl.convertToListing(node, d);
            } else if (node.getNodeName().equals("literal")) {
                LiteralImpl.ConvertToLiteral(node, d);
            }
        }
    }

    @Override
    public Document parse(String filename) {
        return null;
    }

    @Override
    public void parseByString(String s) {
    }

    @Override
    public Document parse(FileInputStream fstream) {
        return null;
    }
}
