package personal.ivan.parse;

import personal.ivan.domain.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ChooseParser {
    enum Parser {
        one {
            Document parse() {
                AsciidocParser parser = new AsciidocParser();
                Document d = parser.parseAsciiDocument("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\crptascii.adoc");
                return d;
            }
        },
        two {
            Document parse() {
                HtmlParser parser = new HtmlParser();
                Document d = parser.parse("C:\\Users\\i.haritonin\\MyProjects\\TextParse\\src\\test\\resources\\crptascii.adoc");
                return d;
            }
        }
    }

    public int chooseParserMethod(String filename) {
        Map<Parser, Function<String, Document>> m = new HashMap<>();
        var arr = filename.split(".");
        if (arr[arr.length - 1] == "txt") {
            return 1;
        } else if (arr[arr.length - 1] == "adoc") {
            return 2;
        } else {
            return 3;
        }
    }
}
