package personal.ivan.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import personal.ivan.domain.Paragraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HtmlParser implements IParse{
    @Override
    public personal.ivan.domain.Document parse(String filename) {
        File in = new File(filename);
        try {
            Document doc = Jsoup.parse(in, null);
            Elements paragraphs = doc.select("p");
            Paragraph par;
            personal.ivan.domain.Document docu = new personal.ivan.domain.Document("Document");
            for(Element p : paragraphs) {
                String ss = p.text();
                System.out.println(ss);
                par = new Paragraph(ss);
                docu.getElements().add(par);
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
    public personal.ivan.domain.Document parse(FileInputStream fstream) {
        return null;
    }
}
