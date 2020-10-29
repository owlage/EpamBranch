package workingWithAStrAsAnArrayOfCharacters;

//3. В строке найти количество цифр.

public class NumThree {

    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = Util.stringInput();
        int counter = 0; // счётчик цифр
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);//символ строки приводим к char
            if (ch >= 48 && ch <= 57) { //если символ строки входит в период [48,57] в табл unicode, тогда счётчик +1
                counter++;
            }
        }
        System.out.println("Кол - во цифр в строке = " + counter);
    }
}
