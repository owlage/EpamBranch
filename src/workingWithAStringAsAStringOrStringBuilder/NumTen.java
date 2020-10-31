package workingWithAStringAsAStringOrStringBuilder;

/*
10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
восклицательным или вопросительным знаком. Определить количество предложений в строке X.
 */

public class NumTen {

    public static void main(String[] args) {
        System.out.println("Введите предложения. Предложения должны оканчиваться '.''!''?'");
        String str = UtilWorkingStringBuilder.stringInput();
        int offers = 0;//счётчик предложений
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 33 || ch == 46 || ch == 63){//символы в таблице юникод
                offers++;
            }
        }
        if (!str.endsWith(".") || !str.endsWith("!") || str.endsWith("?")){
            offers++;
            System.out.println("В конце строки вы не поставили симпол '.' или '!' или '?'");
        }
        System.out.println("Кол-во предложений = " + offers);
    }
}
