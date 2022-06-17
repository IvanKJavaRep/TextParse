package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import personal.ivan.domain.Literal;

public class LiteralImpl {
    public static Literal ConvertToLiteral(StructuralNode node) {
        Literal lit = new Literal("literal", node.getContent().toString());
        lit.setProperties(node.getAttributes());
        return lit;
    }
}
