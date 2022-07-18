package personal.ivan.parse;

import personal.ivan.enums.ParserType;

import java.util.EnumMap;

public class ParserHolderAsPrototype implements ICloneable {
    EnumMap<ParserType, IParse> enumMap = new EnumMap<>(ParserType.class);

    public ParserHolderAsPrototype() {
        enumMap.put(ParserType.ASCII, new AsciidocParser());
        enumMap.put(ParserType.HTML, new HtmlParser());
        enumMap.put(ParserType.TXT, new TxtParser());


    }

    public ParserHolderAsPrototype(EnumMap<ParserType, IParse> enumMap1) {
        enumMap = enumMap1;
    }

    public IParse chooseParserObject(ParserType p) {
        return enumMap.get(p);
    }

    public IParse chooseParserObject(String filename) {
        return chooseParserObject(ParserType.of(filename));
    }

    @Override
    public ParserHolderAsPrototype copy() {
        ParserHolderAsPrototype parserHolderAsPrototype = new ParserHolderAsPrototype(this.enumMap);
        return parserHolderAsPrototype;
    }
}

