package workingWithAStringAsAStringOrStringBuilder;

//4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.

public class NumFour {

    public static void main(String[] args) {
        String str = "информатика";
        String line = str.substring(7, 8).concat(str.substring(3,5).concat(str.substring(7, 8)));
        System.out.println(line);
    }
}
