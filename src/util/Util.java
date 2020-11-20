package util;

import java.util.Scanner;

public class Util {

    static int arrLength;

    static String stringInput() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    static int arrayInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            arrLength = sc.nextInt();
            if (arrLength < 2) {
                System.out.println("Введите число больше чем 2");
                arrayInput();
            }
        } else {
            System.out.println("Введите целое число");
            arrayInput();
        }
        return arrLength;
    }
}
