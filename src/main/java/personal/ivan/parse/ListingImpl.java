package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import personal.ivan.domain.Document;
import personal.ivan.domain.Listing;

public class ListingImpl {
    public static void convertToListing(StructuralNode node, Document doc) {
        Listing listing = new Listing("listing", node.getContent().toString());
        doc.elements.add(listing);
    }
}
