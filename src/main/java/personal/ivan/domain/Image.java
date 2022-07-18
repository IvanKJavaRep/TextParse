package personal.ivan.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.nio.file.Path;
import java.util.Map;

@Getter
@Setter
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

    public void SetMemento(Memento memento) {
        path = memento.getPath();
        map = memento.getMap();

    }

    public Memento GetMemento() {
        return new Memento(this.path, this.map);
    }


}

