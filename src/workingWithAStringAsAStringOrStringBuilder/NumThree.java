package workingWithAStringAsAStringOrStringBuilder;

//3. Проверить, является ли заданное слово палиндромом.

public class NumThree {

        //убираем все пробелы в строке
        static String removeSpaces(String enteredStr){
            enteredStr.trim();//убираем пробелы в начале и в конце строки
            StringBuilder stringBuilder = new StringBuilder();
            char ch;
            for (int i = 0; i < enteredStr.length(); i++) {
                ch = enteredStr.charAt(i);
                if (ch >= 1040 && ch <= 1103) { //записываем в строку только буквы кирилицы
                    stringBuilder.append(enteredStr.charAt(i));
                } else {
                    stringBuilder.append("");
                }
            }
            return stringBuilder.toString();
        }

        static boolean palindromeСheck(String enteredStr){
            StringBuilder stringBuilder = new StringBuilder(enteredStr);
            stringBuilder.reverse();//переворачиваем строку
            if(enteredStr.equalsIgnoreCase(stringBuilder.toString())){ //сравнение строки без учёта регистра
                return true;
            } else {
                return false;
            }
        }

        public static void main(String[] args) {
            System.out.println("Введите строку, для проверки является ли слово полиндромом");
            String str = UtilWorkingStringBuilder.stringInput();
            String line = removeSpaces(str);//записываем строку без пробелов
            if(palindromeСheck(line)){
                System.out.println("Строка является полиндромом");
            } else {
                System.out.println("Строка не палидром");
            }
        }
}
