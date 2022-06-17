package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import personal.ivan.GlobalConstants;
import personal.ivan.domain.Link;
import personal.ivan.domain.Paragraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphImpl {
    public static Paragraph ConvertToParagraph( StructuralNode node) {
        Paragraph p = new Paragraph(node.getContent().toString());
        p.setProperties(node.getAttributes());
        findLinks(p);
        return p;

    }

    public static void findLinks(Paragraph p) {
        Pattern pat = Pattern.compile(GlobalConstants.regex);
        Matcher mat = pat.matcher(p.getContent());
        while (mat.find()) {
            p.addChild(new Link(mat.group()));
        }
    }
}
