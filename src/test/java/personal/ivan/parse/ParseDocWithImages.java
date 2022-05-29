package personal.ivan.parse;

import org.asciidoctor.ast.StructuralNode;
import org.junit.jupiter.api.Test;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.AsciidocREadFile;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class ParseDocWithImages {
    @Test void test() throws MalformedURLException {
        /*File inputXmlFile = new File(this.getClass().getResource("/testdoc.adoc").getFile());
        System.out.println(inputXmlFile.getAbsolutePath());*/

        AsciidocREadFile reader = new AsciidocREadFile();
        AsciidocParser parser = new AsciidocParser();
        ProcessDocument pd = new ProcessDocument();
        ArrayList<StructuralNode> lst = reader.readTreeAsciidoc("smalldoc.adoc");
        parser.parseAsciidoc(lst);
        //pd.process(parser.GetDocument(), ProcessDocument::processToJson);
    }
}
