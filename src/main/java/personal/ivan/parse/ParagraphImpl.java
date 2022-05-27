package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import personal.ivan.GlobalConstants;
import personal.ivan.domain.Link;
import personal.ivan.domain.Paragraph;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphImpl {
    public static Paragraph ConvertToParagraph( StructuralNode node) {
        Paragraph p = new Paragraph(node.getContent().toString());
        return p;

    }

    public static ArrayList<Link> findLinks(Paragraph p) {
        Pattern pat = Pattern.compile(GlobalConstants.regex);
        Matcher mat = pat.matcher(p.content);
        ArrayList<Link> lst = new ArrayList<>();
        while (mat.find()) {
            lst.add(new Link(mat.group()));
        }
        return lst;
    }
}
