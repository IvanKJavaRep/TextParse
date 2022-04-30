package personal.ivan.read;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadFileTest {
    @Test void test()
    {
        ReadFile rf = new ReadFile();
        rf.Read("input.txt");

    }
}
