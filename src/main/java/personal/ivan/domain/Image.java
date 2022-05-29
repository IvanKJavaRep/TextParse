package personal.ivan.domain;

import java.nio.file.Path;
import java.util.Map;

public class Image extends Element{
    public Map<String, Object> map;
    public Path path;
    public Image(String text, Path p, Map<String, Object> m) {
        super(text);
        path=p;
        map=m;
    }

    @Override
    public void printContent() {

    }
}
