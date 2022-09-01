package personal.ivan.domain;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Memento {
    private Map<String, Object> map = new HashMap<>();
    private Path path;

    public Memento(Path p, Map<String, Object> m) {
        path = p;
        map.putAll(m);
        //map=m;
    }


    public Path getPath() {
        return path;
    }

    public Map<String, Object> getMap() {
        return map;
    }


}
