package personal.ivan.validateDocument;

import org.asciidoctor.ast.StructuralNode;
import org.junit.jupiter.api.Test;
import personal.ivan.GlobalConstants;
import personal.ivan.domain.Image;
import personal.ivan.parse.AsciidocParser;
import personal.ivan.process.ProcessDocument;
import personal.ivan.read.AsciidocREadFile;

import java.io.InvalidObjectException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validatePngNameTest {
    @Test void test() throws MalformedURLException, InvalidObjectException {
        /*File inputXmlFile = new File(this.getClass().getResource("/testdoc.adoc").getFile());
        System.out.println(inputXmlFile.getAbsolutePath());*/
        AsciidocREadFile reader = new AsciidocREadFile();
        AsciidocParser parser = new AsciidocParser();
        ProcessDocument pd = new ProcessDocument();
        ArrayList<StructuralNode> lst = reader.readTreeAsciidoc("smalldoc.adoc");
        parser.parseAsciidoc(lst);
        for (var obj : parser.GetDocument().elements)
        {
            if(obj instanceof Image) {
                Pattern pat = Pattern.compile(GlobalConstants.pngRegexp);
                String s = ((Image) obj).path.getFileName().toString();
                Matcher mat = pat.matcher(s);
                if (!(mat.find() && mat.group().length() == s.length())) {
                    throw new InvalidObjectException("invalid name");
                }
            }
        }
    }
}
