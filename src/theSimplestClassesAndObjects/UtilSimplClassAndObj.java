package theSimplestClassesAndObjects;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilSimplClassAndObj {

    static int number;
    static String str;

    static int numberInput(){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            number = sc.nextInt();
        } else {
            System.out.println("Введите целое число");
            numberInput();
        }
        return number;
    }

    static String strInput(){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()){
            str = sc.nextLine();
            str = str.replaceAll("[^А-Яа-я]","");
        } else {
            strInput();
        }
        return str;
    }
}
