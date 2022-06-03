package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import org.junit.jupiter.api.Test;
import personal.ivan.read.AsciidocREadFile;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ListInTableCellTest {
    @Test
    void test() {
        AsciidocREadFile reader = new AsciidocREadFile();
        ArrayList<StructuralNode> lst = reader.readTreeAsciidoc("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\crptascii.adoc");
        ArrayList<StructuralNode> tables = new ArrayList<>();
        for (var c : lst) {
            if (c instanceof Table) {
                tables.add(c);
            }
        }
        Assertions.assertEquals(14, tables.size());
    }
}
