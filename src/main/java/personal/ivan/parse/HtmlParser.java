package personal.ivan.parse;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import personal.ivan.domain.Paragraph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlParser implements IParse{
    @Override
    public void parse(String filename) {
        Gson g = new Gson();
        File in = new File(filename);
        try {
            Document doc = Jsoup.parse(in, null);
            Elements paragraphs = doc.select("p");
            Paragraph par;
            for(Element p : paragraphs) {
                String ss = p.text();
                System.out.println(ss);
                par = new Paragraph(ss);
                System.out.println(par.content);
                String jsonp = g.toJson(par);
                FileWriter fw = new FileWriter("output_html.txt",true);
                fw.write(jsonp);
                fw.flush();
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
