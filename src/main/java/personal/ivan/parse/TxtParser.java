package personal.ivan.parse;

import com.google.gson.Gson;
import personal.ivan.domain.Document;
import personal.ivan.domain.Element;
import personal.ivan.domain.Paragraph;
import personal.ivan.domain.TxtList;

public class TxtParser implements IParse {

    Document docu = new Document("Document");
    String current = "";
    Gson g = new Gson();

    @Override
    public Document parse(String filename) {
        return null;
    }

    @Override
    public void parseByString(String s) {
        if (s.length() == 0 && current != "") {
            Paragraph p = new Paragraph(current);
            //String json = g.toJson(p);
            TxtList txtL = p.searchForList();
            //String jsonList = "";
            docu.elements.add((Element) p);
            docu.elements.add((Element) txtL);
            current = "";
        } else if (s.length() != 0) {
            current += s;
            current += "\n";
        }
    }
}
