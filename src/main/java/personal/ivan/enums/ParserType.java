package personal.ivan.enums;

import personal.ivan.parse.AsciidocParser;
import personal.ivan.parse.HtmlParser;
import personal.ivan.parse.IParse;
import personal.ivan.parse.TxtParser;

import java.util.EnumMap;

public class ParserType {
    EnumMap<Parser, IParse> enumMap = new EnumMap<Parser, IParse>(Parser.class);

    public ParserType() {
        enumMap.put(Parser.ascii, new AsciidocParser());
        enumMap.put(Parser.html, new HtmlParser());
        enumMap.put(Parser.txt, new TxtParser());

    }

    public IParse chooseParserObject(Parser p) {
        return enumMap.get(p);
    }

    public enum Parser {
        ascii,
        html,
        txt
    }

    public Parser chooseParserNumber(String filename) {
        var arr = filename.split("\\.");
        if (arr[arr.length - 1] == "adoc") {
            return Parser.ascii;
        } else if (arr[arr.length - 1] == "html") {
            return Parser.html;
        } else {
            return Parser.txt;
        }
    }

}
