package personal.ivan.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import personal.ivan.domain.Document;
import personal.ivan.domain.Paragraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AsciidocParser implements IParse {

    @Override
    public Document parse(String filename) {
        File in = new File(filename);
        try {
            org.jsoup.nodes.Document doc = Jsoup.parse(in, null);
            Elements paragraphs = doc.select("p");
            Paragraph par;
            personal.ivan.domain.Document docu = new personal.ivan.domain.Document("Document");
            for(Element p : paragraphs) {
                String ss = p.text();
                System.out.println(ss);
                par = new Paragraph(ss);
                docu.elements.add(par);
            }
            return docu;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void parseByString(String s) {
    }

    @Override
    public Document parse(FileInputStream fstream) {
        return null;
    }
}
