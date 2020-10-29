package workingWithAStrAsAnArrayOfCharacters;

//4.В строке найти количество чисел.

public class NumFour {

    //проверяем на цифру
    static boolean checkForNumber(char ch){
        boolean bool = false;
        if (ch >= 48 && ch <= 57) { //если символ строки входит в период [48,57] в табл unicode. возвращаем true
            bool = true;
        }
        return bool;
    }

    public static void main(String[] args) {
        System.out.println("Введите строку");
        String str = Util.stringInput();
        int counter = 0;//счётчик
        for (int i = 0; i < str.length(); i++) {
            if (checkForNumber(str.charAt(i))){ // поиск чисел, если всчтречаем число идем переходим дальше в проверку
                if(i == str.length() - 1 || !checkForNumber(str.charAt(i + 1))){//если следующий знак не цифра счётчик+1
                    counter++;
                }
            }
        }
        System.out.println("Кол - во чисел в строке = " + counter);
    }
}
