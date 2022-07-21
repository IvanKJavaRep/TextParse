package personal.ivan.domain;

public interface IVisitor {
    String visit(Link l);

    String visit(Paragraph p);
}
