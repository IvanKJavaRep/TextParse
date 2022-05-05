package personal.ivan.read;

import personal.ivan.parse.TxtParser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile implements IReadable {

    @Override
    public void Read(String filename)  {
        try {

            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            TxtParser parser = new TxtParser();
            while((line=br.readLine())!=null)
            {
                parser.parse(line);
            }
            parser.parse("");
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
