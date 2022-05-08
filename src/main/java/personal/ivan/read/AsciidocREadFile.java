package personal.ivan.read;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;

import java.io.File;
import java.io.FileInputStream;

public class AsciidocREadFile implements IReadable{
    @Override
    public FileInputStream Read(String filename) {
        try {
            Asciidoctor adoc = Asciidoctor.Factory.create();
            adoc.convertFile(new File(filename),
                    OptionsBuilder.options().toFile(new File("outputAsci.html"))
                            .safe(SafeMode.UNSAFE));
            FileInputStream fstream = new FileInputStream("outputAsci.html");
            return fstream;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
