package personal.ivan.domain;

import lombok.Data;

@Data
public class Listing extends Element {
    private String source;

    public Listing(String text, String code) {
        super(text);
        source = code;
    }

    @Override
    public void printContent() {

    }
}
