package workingWithAStringAsAStringOrStringBuilder;
/*
7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
Например, если было введено "abc cde def", то должно быть выведено "abcdef".
 */

public class NumSeven {

    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = UtilWorkingStringBuilder.stringInput();
        StringBuilder stringBuilder = new StringBuilder();
        //сначала удалил все пробелы из строки
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("");
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        //из строки без пробелов удаляем все повторения
        for (int i = 0; i < stringBuilder.length(); i++) {
            for (int j = i + 1; j < stringBuilder.length(); j++) {
                if (stringBuilder.charAt(i) == stringBuilder.charAt(j)) {
                    stringBuilder.deleteCharAt(j);
                    j--;//если символ удален то проверку начинаем с места удаленного символа
                }
            }
        }
        System.out.println("Новая строка без повторений и пробелов");
        System.out.println(stringBuilder.toString());
    }
}
