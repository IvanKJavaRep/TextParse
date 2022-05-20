package personal.ivan.read;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.asciidoctor.ast.Document;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import static org.asciidoctor.Asciidoctor.Factory.create;

public class AsciidocREadFile implements IReadable {
    ArrayList<StructuralNode> lst = new ArrayList<>();

    public ArrayList<StructuralNode> readTreeAsciidoc() {
        Asciidoctor asciidoctor = create();
        Document document = asciidoctor.loadFile(new File("crptascii.adoc"), Options.builder().build());
        for (var block : document.getBlocks()
        ) {
            GetAllBlocks(block);
        }
        System.out.println(lst.size());

        return lst;
    }

    public void GetAllBlocks(StructuralNode block) {
        System.out.println(block.getNodeName());
        if (block.getNodeName().equals("ulist")) {
            lst.add(block);
            return;
        }
        if (block instanceof Table) {
            lst.add(block);
            return;
        }
        if (block.getBlocks().size() == 0) {
            lst.add(block);
        } else {
            for (var b : block.getBlocks()
            ) {
                GetAllBlocks(b);
            }
        }
    }

    @Override
    public FileInputStream Read(String filename) {
        try {
            Asciidoctor adoc = Asciidoctor.Factory.create();
            adoc.convertFile(new File(filename),
                    OptionsBuilder.options().toFile(new File("crptascii.html"))
                            .safe(SafeMode.UNSAFE));
            FileInputStream fstream = new FileInputStream("outputAsci.html");
            return fstream;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
