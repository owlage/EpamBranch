package workingWithAStringAsAStringOrStringBuilder;

//6. Из заданной строки получить новую, повторив каждый символ дважды.

public class NumSix {

    public static void main(String[] args) {
        String line;
        String str = UtilWorkingStringBuilder.stringInput();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 3; j++) {//3 раза записываем символ тоесть сам символ и 2 его повторения
                stringBuilder.append(str.charAt(i));
            }
        }
        line = stringBuilder.toString();
        System.out.println(line);
    }
}
