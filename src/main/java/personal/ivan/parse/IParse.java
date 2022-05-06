package personal.ivan.parse;

import personal.ivan.domain.Document;

interface IParse {
    public Document parse(String filename);
    void parseByString(String s);
}
