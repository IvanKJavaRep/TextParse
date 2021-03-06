package personal.ivan;

import personal.ivan.domain.Document;

public class GlobalConstants {
    public static Document doc = new Document("document");
    // ищет url в тексте с доменами на любом языке.
    public static String regex = "\\b(https?|ftp|file)://[-\\p{L}0-9+&@#/%?=~_|!:,.;]*[-\\p{L}0-9+&@#/%=~_|]";
    // проверяет, являетсял фото в формате png транслитом, в котором слова разделены _
    public static String pngRegexp = "[a-z]+(_[a-z]+)*\\.(PNG|png)";
}
