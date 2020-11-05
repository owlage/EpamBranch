package theSimplestClassesAndObjects;

import java.util.Scanner;

public class UtilSimplClassAndObj {

    static int number;

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
}
