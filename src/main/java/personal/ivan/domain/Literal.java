package personal.ivan.domain;

public class Literal extends Element {
    public String source;

    public Literal(String text, String cont) {
        super(text);
        source = cont;
    }

    @Override
    public void printContent() {

    }
}
