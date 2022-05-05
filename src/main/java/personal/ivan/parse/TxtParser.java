package personal.ivan.parse;

import com.google.gson.Gson;
import personal.ivan.domain.Paragraph;
import personal.ivan.domain.TxtList;

import java.io.FileWriter;

public class TxtParser implements IParse {

    String current = "";
    Gson g = new Gson();

    @Override
    public void parse(String s) {
        if (s.length() == 0 && current != "") {
            Paragraph p = new Paragraph(current);
            String json = g.toJson(p);
            TxtList txtL = p.searchForList();
            String jsonList = "";
            try (FileWriter fw = new FileWriter("output.txt", true)) {
                fw.write(json);
                fw.write("\n");
                if (txtL.lst.size() > 0) {
                    jsonList = g.toJson(p.searchForList());
                    fw.write(jsonList);
                    fw.write("\n");
                }
                fw.write("\n");
            } catch (Exception e) {

            }
            current = "";
        } else if (s.length() != 0) {
            current += s;
            current += "\n";
        }
    }
}
