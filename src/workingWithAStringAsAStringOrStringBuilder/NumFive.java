package workingWithAStringAsAStringOrStringBuilder;

public class NumFive {

    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = UtilWorkingStringBuilder.stringInput();
        int count = 0;
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if(ch == 97 || ch == 1072){//таблица юникод 'а'- английская 'а'-русская
                count++;
            }
        }
        System.out.println("Букв 'а' в строке = " + count);
    }
}
