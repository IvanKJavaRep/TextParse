package personal.ivan.parse;

import personal.ivan.domain.Document;

import java.io.FileInputStream;

public interface IParse {
    Document parse(String filename);
    void parseByString(String s);
    Document parse(FileInputStream fstream);
}
