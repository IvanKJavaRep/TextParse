package personal.ivan.parse;

import org.asciidoctor.ast.List;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import personal.ivan.domain.*;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AsciidocParser implements IParse {

    public static Document d = new Document("document");

    public Document GetDocument() {
        return d;
    }

    public static void parseAsciidoc(ArrayList<StructuralNode> lst) throws MalformedURLException {
        for (var node : lst
        ) {
            System.out.println(node.getNodeName());
            if (node.getContext() == "paragraph") {
                Paragraph p = ParagraphImpl.ConvertToParagraph(node);
                ArrayList<Link> links = ParagraphImpl.findLinks(p);
                d.elements.add(p);
                for (var li : links) {
                    d.elements.add(li);
                }
            } else if (node instanceof List) {
                TxtList txtlst = UListImpl.ConvertToTxtList(node);
                d.elements.add(txtlst);
                ArrayList<Link> links1 = UListImpl.FindLinks(node);
                for (var li : links1) {
                    d.elements.add(li);
                }
            } else if (node instanceof Table) {
                d.elements.add(TableImpl.ConvertToTable(node));
            } else if (node.getNodeName().equals("listing")) {
                d.elements.add(ListingImpl.convertToListing(node));
                ArrayList<Link> links2 = ListingImpl.findLinks(node);
                for (var li : links2) {
                    d.elements.add(li);
                }
            } else if (node.getNodeName().equals("literal")) {
                d.elements.add(LiteralImpl.ConvertToLiteral(node));
            } else if (node.getNodeName().equals("image")) {
                Path p = Paths.get(node.getAttributes().get("target").toString());
                d.elements.add(new Image("image", p, node.getAttributes()));
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
