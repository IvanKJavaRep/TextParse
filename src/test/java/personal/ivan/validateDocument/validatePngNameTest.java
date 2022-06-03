package personal.ivan.validateDocument;

import org.junit.jupiter.api.Test;

import java.io.InvalidObjectException;
import java.net.MalformedURLException;

public class validatePngNameTest {
    @Test void test() throws MalformedURLException, InvalidObjectException {
        /*File inputXmlFile = new File(this.getClass().getResource("/testdoc.adoc").getFile());
        System.out.println(inputXmlFile.getAbsolutePath());*/
        /*AsciidocREadFile reader = new AsciidocREadFile();
        AsciidocParser parser = new AsciidocParser();
        ProcessDocument pd = new ProcessDocument();
        ArrayList<StructuralNode> lst = reader.readTreeAsciidoc("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\smalldoc.adoc");
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
        }*/
    }
}
