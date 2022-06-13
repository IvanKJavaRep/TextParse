package personal.ivan.parse;

import org.asciidoctor.ast.ListItem;
import org.asciidoctor.ast.Section;
import org.asciidoctor.ast.Table;
import org.asciidoctor.ast.*;
import org.asciidoctor.jruby.ast.impl.ListItemImpl;
import personal.ivan.domain.Cell;
import personal.ivan.domain.Document;
import personal.ivan.domain.*;
import personal.ivan.read.AsciidocReadFile;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AsciidocParser implements IParse {

    public static Document d = new Document("document");

    public Document GetDocument() {
        return d;
    }

    public Document parseAsciiDocument(String file) {
        AsciidocReadFile reader = new AsciidocReadFile();
        org.asciidoctor.ast.Document asciiDoc = reader.readDocument(file);
        Document resultDoc = new Document(asciiDoc.getNodeName());
        java.util.List<StructuralNode> nodes = asciiDoc.getBlocks();
        for (StructuralNode st : nodes) {
            resultDoc.addChild(parseStructuralNode(st));
        }
        return resultDoc;
    }

    public Element parseStructuralNode(StructuralNode stNode) {
        //System.out.println(stNode.getNodeName());
        if (stNode instanceof org.asciidoctor.ast.List) {
            TxtList txtlst = new TxtList(stNode.getNodeName());
            List f = (List) stNode;
            for (var n : f.getItems()
            ) {
                ListItem li = (ListItem) n;
                personal.ivan.domain.ListItem myListItem = new personal.ivan.domain.ListItem(li.getText());
                for (var item : ((ListItemImpl) (li)).getBlocks()) {
                    myListItem.addChild(parseStructuralNode(item));
                }
                txtlst.addChild(myListItem);
            }
            return txtlst;
        } else if (stNode instanceof org.asciidoctor.ast.Table) {
            personal.ivan.domain.Table table = TableImpl.ConvertToTable(stNode);
            Table t = (Table) stNode;
            for (var el : t.getHeader()) {
                for (var cell : el.getCells()) {
                    Cell myCell = new Cell(cell.getText());
                    for (var l : TableImpl.findLinks(cell)) {
                        myCell.addChild(l);
                    }
                    var document = cell.getInnerDocument();
                    if (document != null) {
                        for (var b : document.getBlocks()) {
                            myCell.addChild(parseStructuralNode(b));
                        }
                        table.addChild(myCell);
                    } else {
                        table.addChild(myCell);
                    }
                }
            }
            for (var el : t.getBody()) {
                for (var cell : el.getCells()) {
                    Cell myCell = new Cell(cell.getText());
                    for (var l : TableImpl.findLinks(cell)) {
                        myCell.addChild(l);
                    }
                    var document = cell.getInnerDocument();
                    if (document != null) {
                        for (var b : document.getBlocks()) {
                            myCell.addChild(parseStructuralNode(b));
                        }
                        table.addChild(myCell);
                    } else {
                        table.addChild(myCell);
                    }
                }
            }
            return table;
        } else if (stNode.getNodeName().equals("listing")) {
            return ListingImpl.convertToListing(stNode);
        } else if (stNode.getNodeName().equals("paragraph")) {
            Paragraph p = ParagraphImpl.ConvertToParagraph(stNode);
            return p;
        } else if (stNode.getNodeName().equals("literal")) {
            return LiteralImpl.ConvertToLiteral(stNode);
        } else if (stNode.getNodeName().equals("image")) {
            Path p = Paths.get(stNode.getAttributes().get("target").toString());
            return new Image("image", p, stNode.getAttributes());
        } else if (stNode instanceof Section) {
            personal.ivan.domain.Section section = new personal.ivan.domain.Section("section");
            for (var e : stNode.getBlocks()) {
                section.addChild(parseStructuralNode(e));
            }
            return section;
        } else {
            return null;
        }
    }

    /*public static void parseAsciidoc(ArrayList<StructuralNode> lst) {
        for (var node : lst
        ) {
            System.out.println(node.getNodeName());
            if (node.getContext() == "paragraph") {
                Paragraph p = ParagraphImpl.ConvertToParagraph(node);
                //ArrayList<Link> links = ParagraphImpl.findLinks(p);
                d.elements.add(p);
                *//*for (var li : links) {
                    d.elements.add(li);
                }*//*
            } else if (node instanceof List) {
                TxtList txtlst = UListImpl.ConvertToTxtList(node);
                d.elements.add(txtlst);
                ArrayList<Link> links1 = UListImpl.FindLinks(node);
                for (var li : links1) {
                    d.elements.add(li);
                }
            } else if (node instanceof Table) {
                d.elements.add(TableImpl.ConvertToTable(node));
            } else if (node.getNodeName().equals("listing")) {
                d.elements.add(ListingImpl.convertToListing(node));
                ArrayList<Link> links2 = ListingImpl.findLinks(node);
                for (var li : links2) {
                    d.elements.add(li);
                }
            } else if (node.getNodeName().equals("literal")) {
                d.elements.add(LiteralImpl.ConvertToLiteral(node));
            } else if (node.getNodeName().equals("image")) {
                Path p = Paths.get(node.getAttributes().get("target").toString());
                d.elements.add(new Image("image", p, node.getAttributes()));
            }
        }
    }*/

    @Override
    public Document parse(String filename) {
        return null;
    }

    @Override
    public void parseByString(String s) {
    }

    @Override
    public Document parse(FileInputStream fstream) {
        return null;
    }
}
