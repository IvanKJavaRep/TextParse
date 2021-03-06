package personal.ivan.parse;

import personal.ivan.domain.Document;
import personal.ivan.domain.Paragraph;
import personal.ivan.domain.TxtList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class TxtParser implements IParse {

    Document docu = new Document("Document");
    String current = "";

    @Override
    public Document parse(String filename) {
        try {
            return parse(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void parseByString(String s) {
        if (s.length() == 0 && current != "") {
            Paragraph p = new Paragraph(current);
            TxtList txtL = p.searchForList();
            docu.getElements().add(p);
            docu.getElements().add(txtL);
            current = "";
        } else if (s.length() != 0) {
            current += s;
            current += "\n";
        }
    }

    @Override
    public Document parse(FileInputStream fstream) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            while ((line = br.readLine()) != null) {
                this.parseByString(line);
            }
            this.parseByString("");
            return docu;
        } catch (Exception e) {

        }
        return null;
    }
}
