package personal.ivan.parse;

public interface ICloneable {
    //если бы парсерхолдер был чьим-то наследником, то можно было бы
    //сделать тип возврата этого объекта, но у нас тут нет никакой иерархии
    ParserHolderAsPrototype copy();
}
