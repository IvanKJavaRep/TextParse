package personal.ivan.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Element {
    private String content;
    private List<Element> children = new ArrayList<>();
    private java.util.Map<String, Object> properties = new HashMap<>();

    public abstract void printContent();

    public Element(String text) {
        content = text;
    }

    public void addChild(Element el) {
        children.add(el);
    }

    @JsonGetter
    public String getContent() {
        return content;
    }

    @JsonGetter
    public List<Element> getChildren() {
        return children;
    }

    @JsonGetter
    public java.util.Map<String, Object> getProperties() {
        return properties;
    }

    @JsonSetter
    public void setContent(String s) {
        content = s;
    }

    @JsonSetter
    public void setChildren(List<Element> el) {
        children = el;
    }

    @JsonSetter
    public void setProperties(java.util.Map<String, Object> m) {
        properties = m;
    }
}
