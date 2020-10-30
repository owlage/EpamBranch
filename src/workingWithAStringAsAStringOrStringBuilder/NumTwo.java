package workingWithAStringAsAStringOrStringBuilder;

//2. В строке вставить после каждого символа 'a' символ 'b'.

public class NumTwo {

    static String boxB (String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a'){//если в строке встречается символ 'a', то мы создаем строку с символом 'a' и 'b'
                stringBuilder.append("a");
                stringBuilder.append("b");
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = UtilWorkingStringBuilder.stringInput();
        System.out.println("Новая строка");
        System.out.println(boxB(str));
    }
}
