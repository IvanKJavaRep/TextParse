package personal.ivan.read;

import java.io.FileInputStream;

public class ReadFile implements IReadable {

    @Override
    public FileInputStream Read(String filename)  {
        try {

            FileInputStream fstream = new FileInputStream(filename);
            return fstream;
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
