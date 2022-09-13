package personal.ivan.postgresql;

import java.util.HashMap;
import java.util.Map;

public class KeysInfo {
    //для каждой таблицы создадим список из назвния таблицы+название столбца, основываясь
    // на внешних ключах, чтобы можно было делать селекты из других таблиц и
    // создавать поля, содержащие другие объекты.
    Map<String, String> keysDescription = new HashMap<>();
}
