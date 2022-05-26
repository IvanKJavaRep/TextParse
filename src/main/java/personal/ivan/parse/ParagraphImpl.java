package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import personal.ivan.domain.Document;
import personal.ivan.domain.Link;
import personal.ivan.domain.Paragraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphImpl {
    public static void ConvertToParagraph(Document doc, StructuralNode node) {
        Paragraph p = new Paragraph(node.getContent().toString());
        doc.elements.add(p);
        findLinks(doc, p);
        


    }

    public static void findLinks(Document doc, Paragraph p) {
        // ищет url в тексте с доменами на любом языке.
        String regex = "\\b(https?|ftp|file)://[-\\p{L}0-9+&@#/%?=~_|!:,.;]*[-\\p{L}0-9+&@#/%=~_|]";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(p.content);
        while (mat.find()) {
            doc.elements.add(new Link(mat.group()));
        }
    }
}
