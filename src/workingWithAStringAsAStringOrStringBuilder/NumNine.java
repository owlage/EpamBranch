package workingWithAStringAsAStringOrStringBuilder;

//9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
// Учитывать только английские буквы.

public class NumNine {

    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = UtilWorkingStringBuilder.stringInput();
        int smallLetters = 0, bigLetters = 0;//счётчики больших и маленьких букв
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 65 && ch <= 90){//большие буквы таблица юникод
                bigLetters++;
            }
            if(ch >= 97 && ch <= 122){//маленькие буквы таблица юникод
                smallLetters++;
            }
        }
        System.out.println("Больших букв в строке = " + bigLetters + ", маленьких букв = " + smallLetters);
    }
}
