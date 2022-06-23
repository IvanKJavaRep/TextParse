package personal.ivan.parse;

import personal.ivan.enums.ParserType;

import java.util.EnumMap;

public class ParserHolder {
    EnumMap<ParserType, IParse> enumMap = new EnumMap<>(ParserType.class);

    public ParserHolder() {
        enumMap.put(ParserType.ASCII, new AsciidocParser());
        enumMap.put(ParserType.HTML, new HtmlParser());
        enumMap.put(ParserType.TXT, new TxtParser());


    }

    public IParse chooseParserObject(ParserType p) {
        return enumMap.get(p);
    }

    public IParse chooseParserObject(String filename) {
        return chooseParserObject(ParserType.of(filename));
    }
}
