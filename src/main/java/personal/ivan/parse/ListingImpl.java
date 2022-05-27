package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import personal.ivan.domain.Document;
import personal.ivan.domain.Link;
import personal.ivan.domain.Listing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListingImpl {
    public static void convertToListing(StructuralNode node, Document doc) {
        Listing listing = new Listing("listing", node.getContent().toString());
        doc.elements.add(listing);
        findLinks(node, doc);
    }

    public static void findLinks(StructuralNode node, Document doc) {
        String regex = "\\b(https?|ftp|file)://[-\\p{L}0-9+&@#/%?=~_|!:,.;]*[-\\p{L}0-9+&@#/%=~_|]";
        String content = node.getContent().toString();
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(content);
        while (mat.find()) {
            doc.elements.add(new Link(mat.group()));
        }
    }
}
