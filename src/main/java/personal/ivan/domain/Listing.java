package personal.ivan.domain;

public class Listing extends Element {
    public String source;

    public Listing(String text, String code) {
        super(text);
        source = code;
    }

    @Override
    public void printContent() {

    }
}
