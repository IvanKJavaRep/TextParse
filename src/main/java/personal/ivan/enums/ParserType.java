package personal.ivan.enums;


import java.util.Objects;

public enum ParserType {
    ASCII,
    HTML,
    TXT;

    public static ParserType of(String filename) {
        var arr = filename.split("\\.");
        if (Objects.equals(arr[arr.length - 1], "adoc")) {
            return ParserType.ASCII;
        } else if (Objects.equals(arr[arr.length - 1], "html")) {
            return ParserType.HTML;
        } else {
            return ParserType.TXT;
        }
    }
}

