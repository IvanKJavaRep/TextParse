package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import org.junit.jupiter.api.Test;
import personal.ivan.read.AsciidocREadFile;

import java.util.ArrayList;

public class ListInTableCellTest {
    @Test void test()
    {
        AsciidocREadFile reader = new AsciidocREadFile();
        AsciidocParser parser = new AsciidocParser();
        ArrayList<StructuralNode> lst  = reader.readTreeAsciidoc();
        ArrayList<StructuralNode> tables = new ArrayList<>();
        for(var c : lst)
        {
            if(c instanceof Table)
            {
                tables.add(c);
            }
        }
        System.out.println(tables.size());
        for(var c: tables)
        {
            Table t = (Table) c;
            t.getBody();
        }
        /*Document d = parser.parseAscii(lst);
        ProcessDocument pd = new ProcessDocument();
        pd.process(d,ProcessDocument::processToJson);*/
    }
}
