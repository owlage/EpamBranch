package workingWithAStrAsAnArrayOfCharacters;

//5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
// Крайние пробелы в строке удалить.

public class NumFive {

    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = Util.stringInput();//ввод строки
        StringBuilder strBuilder = new StringBuilder();
        String line = str.trim();//убираем первые и последние пробелы
        boolean bool = false;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {//поиск пробелов в строке
                /*
                если не равно bool то в StringBuilder записываем пробел, а далее bool присваиваем true, то есть если
                далее будет пробел, то мы не выполняем ничего, просто пропускаем
                 */
                if (!bool) {
                    strBuilder.append(" ");
                }
                bool = true;
            } else {//если значение не пробел то просто перезаписываем в StringBuilder
                strBuilder.append(line.charAt(i));
                bool = false;
            }
        }
        String line1 = strBuilder.toString();//StringBuilder переводим в строку
        System.out.println("Новая строка");
        System.out.println(line1);
    }
}
