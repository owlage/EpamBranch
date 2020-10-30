package workingWithAStrAsAnArrayOfCharacters;

//2.Замените в строке все вхождения 'word' на 'letter'.

public class NumTwo {
    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = Util.stringInput();
        System.out.println("Новая строка" + str.replace("word", "letter"));
    }
}
