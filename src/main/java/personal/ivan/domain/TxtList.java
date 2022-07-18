package personal.ivan.domain;

import lombok.Data;

@Data
public class TxtList extends Element {
    public TxtList(String content) {
        super(content);
    }

    @Override
    public void printContent() {

    }
}
