package personal.ivan.parse;

import personal.ivan.enums.ParserType;

import java.util.EnumMap;

public class ParserHolder {
    EnumMap<ParserType, IParse> enumMap = new EnumMap<>(ParserType.class);

    private ParserHolder() {
        enumMap.put(ParserType.ASCII, new AsciidocParser());
        enumMap.put(ParserType.HTML, new HtmlParser());
        enumMap.put(ParserType.TXT, new TxtParser());
    }

    public static ParserHolder getInstance() {
        /*if (instance == null) {
            instance = new ParserHolder();
        }*/
        return instance;
    }

    private static final ParserHolder instance = new ParserHolder();

    public IParse chooseParserObject(ParserType p) {
        return enumMap.get(p);
    }

    public IParse chooseParserObject(String filename) {
        return chooseParserObject(ParserType.of(filename));
    }
}
