package personal.ivan.read;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.asciidoctor.ast.Document;
import org.asciidoctor.ast.StructuralNode;
import personal.ivan.domain.Paragraph;
import personal.ivan.domain.TxtList;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import static org.asciidoctor.Asciidoctor.Factory.create;

public class AsciidocREadFile implements IReadable {
    ArrayList<StructuralNode> lst = new ArrayList<>();
    public personal.ivan.domain.Document readTreeAsciidoc() {
        Asciidoctor asciidoctor = create();
        Document document = asciidoctor.loadFile(new File("crptascii.adoc"), Options.builder().build());
        personal.ivan.domain.Document doc = new personal.ivan.domain.Document("Document");
        for (var block : document.getBlocks()
        ) {
            GetAllBlocks(block);
        }
        System.out.println(lst.size());
        for (var node:lst
             ) {
            String s = node.getNodeName();
            if(s.equals("paragraph"))
            {
                //System.out.println("ddd");
                Paragraph p = new Paragraph(node.getContent().toString());
                doc.elements.add(p);
            }
            else if(s.equals("ulist"))
            {
                ArrayList<String> l1 = new ArrayList<>();
                for (var n:node.getBlocks()
                     ) {
                    l1.add(n.toString());
                }
                TxtList l = new TxtList(l1,"list");
                doc.elements.add(l);
            }
        }
        return doc;
    }

    public void GetAllBlocks(StructuralNode block) {
        System.out.println(block.getNodeName());
        if(block.getNodeName().equals("ulist"))
        {
            lst.add(block);
        }
        //System.out.println(1);
        if (block.getBlocks().size() == 0) {
            lst.add(block);
            System.out.println(block.getNodeName());
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
