package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import personal.ivan.domain.Document;
import personal.ivan.domain.Literal;

public class LiteralImpl {
    public static void ConvertToLiteral(StructuralNode node, Document doc) {
        Literal lit = new Literal("literal", node.getContent().toString());
        doc.elements.add(lit);
    }
}
