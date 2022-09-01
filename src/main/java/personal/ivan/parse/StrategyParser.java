package personal.ivan.parse;

import personal.ivan.domain.Document;

public class StrategyParser {
    private String filename;

    public StrategyParser(String filename) {
        this.filename = filename;
    }

    public Document parse(IParse strategy) {
        return strategy.parse(filename);
    }
}
