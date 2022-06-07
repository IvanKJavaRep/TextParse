package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import personal.ivan.GlobalConstants;
import personal.ivan.domain.Link;
import personal.ivan.domain.Listing;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListingImpl {
    public static Listing convertToListing(StructuralNode node) {
        Listing listing = new Listing("listing", node.getContent().toString());
        listing.properties=node.getAttributes();
        for(var e : findLinks(node))
        {
            listing.addChild(e);
        }
        return listing;
    }

    public static ArrayList<Link> findLinks(StructuralNode node) {
        String content = node.getContent().toString();
        Pattern pat = Pattern.compile(GlobalConstants.regex);
        Matcher mat = pat.matcher(content);
        ArrayList<Link> lst = new ArrayList<>();
        while (mat.find()) {
            lst.add(new Link(mat.group()));
        }
        return lst;
    }
}
