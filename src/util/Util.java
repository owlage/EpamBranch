package util;

import java.util.Scanner;

public class Util {

    static int readNumberFromConsole() {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            number = sc.nextInt();
        } else {
            System.out.println("Введите целое число");
            readNumberFromConsole();
        }
        return number;
    }

    static String readAndValidateCyrillicString() {
        String str = "";
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            str = sc.nextLine();
            str = str.replaceAll("[^А-Яа-я]", "");
            if (str.isEmpty()) {
                System.out.println("Вы ввели пустую строку");
                readAndValidateCyrillicString();
            }
        } else {
            readAndValidateCyrillicString();
        }
        return str;
    }

    static String readStringFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static int readArrayLength() {
        int arrLength = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            arrLength = sc.nextInt();
            if (arrLength < 2) {
                System.out.println("Введите число больше чем 2");
                readArrayLength();
            }
        } else {
            System.out.println("Введите целое число");
            readArrayLength();
        }
        return arrLength;
    }
}
