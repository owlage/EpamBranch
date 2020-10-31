package workingWithAStringAsAStringOrStringBuilder;
/*
8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай,
когда самых длинных слов может быть несколько, не обрабатывать.
 */

public class NumEight {

    static String removingSpaces(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String line = str.trim();//убираем первые и последние пробелы
        boolean bool = false;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {//поиск пробелов в строке
                /*
                если не равно bool то в StringBuilder записываем пробел, а далее bool присваиваем true, то есть если
                далее будет пробел, то мы не выполняем ничего, просто пропускаем
                 */
                if (!bool) {
                    stringBuilder.append(" ");
                }
                bool = true;
            } else {//если значение не пробел то просто перезаписываем в StringBuilder
                stringBuilder.append(line.charAt(i));
                bool = false;
            }
        }
        return stringBuilder.toString();
    }

    //кло-во максимальных слов
    static boolean maxWord(String[] strArray) {
        //поиск длинны самого длинного слова
        int max = strArray[0].length();;//счётчик длинны слова
        for (int i = 1; i < strArray.length; i++) {
            if (strArray[i].length() > max) {
                max = strArray[i].length();
            }
        }
        //поиск кол-ва длинных слов
        int coincidences = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (max == strArray[i].length()) {
                coincidences++;
            }
        }
        if (coincidences > 2) {//> чем 2, потому что как минимум одно совпадение будет при проверке
            return false;
        } else {
            return true;
        }
    }

    static void bigWordAndMaxDigits(String[] strArray) {
        String bigWord = null;
        int maxWord = 0;
        if (strArray.length == 1) { //если введено одно слово то записываем его как самое большое
            bigWord = strArray[0];
            maxWord = strArray[0].length();
        } else {
            for (int j = 0; j < strArray.length - 1; j++) {
                if (strArray[j].length() > strArray[j + 1].length()) {
                    bigWord = strArray[j];
                    maxWord = strArray[j].length();
                    String temp = strArray[j];
                    strArray[j] = strArray[j + 1];
                    strArray[j + 1] = temp;
                } else {
                    bigWord = strArray[j + 1];
                    maxWord = strArray[j + 1].length();
                }
            }
        }
        System.out.println("Самое длинное слово " + bigWord + " состоит из " + maxWord + " букв");
    }

    public static void main(String[] args) {
        System.out.println("Введите слова через пробел, все остальные символы будут удалены");
        String str = UtilWorkingStringBuilder.stringInput();
        StringBuilder stringBuilder = new StringBuilder();
        //из строки удаляем все символы кроме букв и пробелов
        str = str.replaceAll("[^a-zA-ZА-Яа-я' ']", "");
        String line = removingSpaces(str);//удаляем все лишние пробелы
        String[] strArray = line.split(" ");//заносим все слова в массив
        if (maxWord(strArray)) {
            bigWordAndMaxDigits(strArray);
        } else {
            System.out.println("В строке самых длинных слов несколько, обработка завершена");
        }
    }
}
