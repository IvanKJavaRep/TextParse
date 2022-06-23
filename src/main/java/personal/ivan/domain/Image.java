package personal.ivan.domain;

import lombok.Data;

import java.nio.file.Path;
import java.util.Map;

@Data
public class Image extends Element{
    private Map<String, Object> map;
    private Path path;
    public Image(String text, Path p, Map<String, Object> m) {
        super(text);
        path=p;
        map=m;
    }

    @Override
    public void printContent() {

    }
}
