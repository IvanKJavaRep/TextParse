package personal.ivan.parse;

import org.asciidoctor.ast.List;
import org.asciidoctor.ast.ListItem;
import org.asciidoctor.ast.StructuralNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import personal.ivan.domain.Document;
import personal.ivan.domain.Link;
import personal.ivan.domain.Paragraph;
import personal.ivan.domain.TxtList;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsciidocParser implements IParse {


    public Document parseAscii(ArrayList<StructuralNode> lst)
    {
        personal.ivan.domain.Document doc = new personal.ivan.domain.Document("Document");
        String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        String s2 = "^(?:(?:http|https)://)?((?:[A-ZА-ЯЁ0-9](?:[A-ZА-ЯЁ0-9-]{0,61}[A-ZА-ЯЁ0-9])?\\.)+(?:[A-ZА-ЯЁ]{2,6}\\.?|[A-ZА-ЯЁ0-9-]{2,}(?<!-)\\.?))(?:/?|[/?]\\S+)$";
        for (var node : lst
        ) {
            String s = node.getNodeName();
            if (s.equals("paragraph")) {
                Paragraph p = new Paragraph(node.getContent().toString());
                doc.elements.add(p);
                Pattern pat = Pattern.compile(regex);
                Matcher mat = pat.matcher(p.content);
                while(mat.find())
                {
                    doc.elements.add(new Link(mat.group()));
                }
            } else if (node instanceof List) {
                List f = (List) node;
                ArrayList<String> l1 = new ArrayList<>();
                for (var n : f.getItems()
                ) {
                    ListItem li = (ListItem) n;
                    l1.add(li.getText());
                    Pattern pat = Pattern.compile(regex);
                    Matcher mat = pat.matcher(li.getText());
                    while(mat.find())
                    {
                        doc.elements.add(new Link(mat.group()));
                    }
                }
                TxtList l = new TxtList(l1, "list");
                doc.elements.add(l);
            }
        }
        return doc;
    }
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
