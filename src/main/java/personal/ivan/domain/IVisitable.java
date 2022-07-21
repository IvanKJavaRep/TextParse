package personal.ivan.domain;

public interface IVisitable {
    String accept(Visitor visitor);
}
