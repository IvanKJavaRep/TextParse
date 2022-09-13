package personal.ivan.domain;

public class Visitor implements IVisitor {

    @Override
    public String visit(Link l) {
        return l.getName();
    }

    @Override
    public String visit(Paragraph p) {
        return p.getName();
    }
}
