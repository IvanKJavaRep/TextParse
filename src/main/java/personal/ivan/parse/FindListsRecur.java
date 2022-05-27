package personal.ivan.parse;

import org.asciidoctor.ast.Document;
import personal.ivan.read.AsciidocREadFile;

public class FindListsRecur {
    public static void FindLists(Document d)
    {
        if(d.getBlocks().size()>0) {
            AsciidocREadFile reader = new AsciidocREadFile();
            AsciidocParser parser = new AsciidocParser();
            reader.GetAllBlocks(d);
            parser.parseAsciidoc(reader.lst);
        }
    }
}
