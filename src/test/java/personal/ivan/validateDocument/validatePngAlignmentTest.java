package personal.ivan.validateDocument;

import org.asciidoctor.ast.StructuralNode;
import org.junit.jupiter.api.Test;
import personal.ivan.domain.Image;
import personal.ivan.parse.AsciidocParser;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.AsciidocREadFile;

import java.io.InvalidObjectException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class validatePngAlignmentTest {
    @Test void test() throws MalformedURLException, InvalidObjectException {
        AsciidocREadFile reader = new AsciidocREadFile();
        AsciidocParser parser = new AsciidocParser();
        ProcessDocument pd = new ProcessDocument();
        ArrayList<StructuralNode> lst = reader.readTreeAsciidoc("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\smalldoc.adoc");
        parser.parseAsciidoc(lst);
        for (var obj : parser.GetDocument().elements)
        {
            if(obj instanceof Image) {
                String s = ((Image) obj).map.get("role").toString();
                if(s.indexOf("text-center")==-1)
                {
                    throw new InvalidObjectException("Invalid role arguement");
                }
                if(!(((Image) obj).map.get("title-align").equals("center")
                        && ((Image) obj).map.get("align").equals("center") &&
                ((Image) obj).map.get("htmlwidth").toString().matches("\\d+%"))) {
                    throw new InvalidObjectException("invalid name");
                }
            }
        }
    }
}
