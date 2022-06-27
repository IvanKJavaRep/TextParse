package personal.ivan.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.nio.file.Path;
import java.util.Map;

@Data
@ToString(callSuper = true)
public class Image extends Element {
    private Map<String, Object> map;
    private Path path;

    @Builder
    public Image(String text, Path p, Map<String, Object> m) {
        super(text);
        path = p;
        map = m;
    }

    @Override
    public void printContent() {

    }
}
