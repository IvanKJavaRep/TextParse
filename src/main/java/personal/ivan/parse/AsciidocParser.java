package personal.ivan.parse;

import org.asciidoctor.ast.List;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import personal.ivan.domain.Document;
import personal.ivan.domain.Paragraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AsciidocParser implements IParse {


    public Document parseAscii(ArrayList<StructuralNode> lst) {
        personal.ivan.domain.Document doc = new personal.ivan.domain.Document("Document");
        for (var node : lst
        ) {
            if (node.getContext() == "paragraph") {
                ParagraphImpl.ConvertToParagraph(doc, node);
            } else if (node instanceof List) {
                doc.elements.add(UListImpl.ConvertToTxtList(node));
                UListImpl.FindLinks(doc, node);
            } else if (node instanceof Table) {
                TableImpl.ConvertToTable(doc,node);
            }
        }
        return doc;
    }
    public void parseAsciidoc(ArrayList<StructuralNode> lst, Document d) {
        //personal.ivan.domain.Document doc = new personal.ivan.domain.Document("Document");
        for (var node : lst
        ) {
            if (node.getContext() == "paragraph") {
                ParagraphImpl.ConvertToParagraph(d, node);
            } else if (node instanceof List) {
                d.elements.add(UListImpl.ConvertToTxtList(node));
                UListImpl.FindLinks(d, node);
            } else if (node instanceof Table) {
                TableImpl.ConvertToTable(d,node);
            }
        }
    }

    @Override
    public Document parse(String filename) {
        File in = new File(filename);
        try {
            org.jsoup.nodes.Document doc = Jsoup.parse(in, null);
            Elements paragraphs = doc.select("p");
            Paragraph par;
            personal.ivan.domain.Document docu = new personal.ivan.domain.Document("Document");
            for (Element p : paragraphs) {
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
