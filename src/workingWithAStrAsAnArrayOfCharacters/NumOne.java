package workingWithAStrAsAnArrayOfCharacters;

//1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.

public class NumOne {

    public static void main(String[] args) {
        System.out.println("Введите кол-во названий переменых");
        int arrayLength = Util.arrayInput();// какое кол-во строк
        String[] array = new String[arrayLength];
        System.out.println("Введите названия переменых черех enter");
        //заполняем массив String введеными строками
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите низвание переменой " + (i + 1));
            array[i] = Util.stringInput();
        }
        char ch;
        for (int i = 0; i < array.length; i++) {
            StringBuilder strBuilder = new StringBuilder();
            for (int j = 0; j < array[i].length(); j++) {
                ch = array[i].toCharArray()[j];//символ строки приводим к char
                //определяем находится ли символ в нижнем регистре если да то возвращаем обновлённый символ в strBuilder
                if (Character.isLowerCase(ch) | Character.isDigit(ch)) {
                    strBuilder.append(ch);
                } else { //если верхний регитр то возвращаем сначала "_", затем переводим нижний регистр
                    strBuilder.append("_");
                    strBuilder.append(Character.toLowerCase(ch));
                }
            }
            array[i] = strBuilder.toString(); // в массив перезаписываем новые значения
        }
        System.out.println("Названия переменых в snake_case ");
        for (String str : array) { // выводим массив array
            System.out.print(str);
        }
    }
}
