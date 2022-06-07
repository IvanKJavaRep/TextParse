package personal.ivan.read;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.ast.Table;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import static org.asciidoctor.Asciidoctor.Factory.create;

public class AsciidocReadFile implements IReadable {
    public ArrayList<StructuralNode> lst = new ArrayList<>();

    public ArrayList<StructuralNode> readTreeAsciidoc(String filename) {
        Asciidoctor asciidoctor = create();
        Document document = asciidoctor.loadFile(new File(filename), Options.builder().build());
        for (var block : document.getBlocks()
        ) {
            GetAllBlocks(block);
        }
        return lst;
    }

    public void GetAllBlocks(StructuralNode block) {
        //System.out.println(block.getNodeName());
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
        return null;
    }

    public Document readDocument(String filename) {
        Asciidoctor asciidoctor = create();
        return asciidoctor.loadFile(new File(filename), Options.builder().build());
    }
}
