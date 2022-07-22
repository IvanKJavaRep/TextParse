package personal.ivan.domain;

public interface IChain {
    void setNextChain(IChain chain);

    void handle(Element element);
}
