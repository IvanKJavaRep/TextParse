package personal.ivan.read;

import personal.ivan.domain.Paragraph;
import personal.ivan.parse.TxtParser;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

public class ReadFile implements IReadable {

    @Override
    public void Read(String filename)  {
        try {
            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            while((line=br.readLine())!=null)
            {
                TxtParser parser = new TxtParser();
                parser.parse(line);
            }
        }catch (Exception e)
        {

        }
        /*File file = new File(filename);
        try(Stream<String> filestream = Files.lines(file.toPath()))
        {
            filestream.forEach(System.out::println);
        }catch (Exception e)
        {

        }*/
    }
}
