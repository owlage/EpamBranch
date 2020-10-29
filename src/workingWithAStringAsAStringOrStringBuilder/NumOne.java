package workingWithAStringAsAStringOrStringBuilder;

//1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.

public class NumOne {

    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = UtilWorkingStringBuilder.stringInput();
        int max = 0;//счётчик пробелов
        int numberOfSpaces = 0;//переменая для хранения предидущего кол-ва пробелов
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {//если находим пробел  то + 1 к мах
                max++;
            }
            //если не равно пробелу, счётчик больше чем переменая для хранения,
            // вторая проверка для подсчёта конечных пробелов
            if (str.charAt(i) != ' ' && numberOfSpaces < max || i == str.length() - 1 && numberOfSpaces < max) {
                numberOfSpaces = max;//переменая для хранения присваеваем значение счётчика
                max = 0;// счётчик равно 0 что бы новые пробелы не плюсовались к старым подсчёиам
            }
            //если не сработа второй if нужно обнулить счётчик,через else почему то не работает
            if (str.charAt(i) != ' ') {
                max = 0;
            }
        }
        System.out.println("Максимальное кол-во пробелов строке = " + numberOfSpaces);
    }
}
