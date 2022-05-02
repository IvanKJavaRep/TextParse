package personal.ivan.parse;

import com.google.gson.Gson;
import personal.ivan.domain.Paragraph;

import java.io.FileWriter;

public class TxtParser implements IParse{

    @Override
    public void parse(String s) {
        Gson g = new Gson();
        Paragraph p = new Paragraph(s);
        String json = g.toJson(p);
        json+=g.toJson(p);
        try (FileWriter fw = new FileWriter("output.txt",true))
        {
            fw.write(json);
        }catch (Exception e)
        {

        }
    }
}
