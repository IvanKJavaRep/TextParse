package personal.ivan.domain;

import java.nio.file.Path;
import java.util.Map;

public class Memento {
    private Map<String, Object> map;
    private Path path;

    public Memento(Path p, Map<String, Object> m) {
        map = m;
        path = p;
    }


    public Path getPath() {
        return path;
    }

    public Map<String, Object> getMap() {
        return map;
    }


}
