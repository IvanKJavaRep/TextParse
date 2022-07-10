package personal.ivan.domain;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.util.Map;

@Getter
@Setter
public class Image extends Element implements ICLonableDomain {
    private Map<String, Object> map;
    private Path path;

    public Image(String text, Path p, Map<String, Object> m) {
        super(text);
        path = p;
        map = m;
    }

    @Override
    public void printContent() {

    }

    @Override
    public Element copy() {
        Image im = new Image(this.getContent(), this.path, this.map);
        return im;
    }
}
