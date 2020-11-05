package theSimplestClassesAndObjects;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Test1 {

    static int numOne;
    static int numTwo;

    static void outputOnDisplay() {
        System.out.println(numOne);
        System.out.println(numTwo);
    }

    static void setChange1(int numberOne) {
        numOne = numberOne;
    }

    static void setChange2(int numberTwo) {
        numTwo = numberTwo;
    }

    static int sum(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    static int greatest(int numberOne, int numberTwo) {
        if (numberOne > numberTwo) {
            return numberOne;
        } else if (numberOne < numberTwo) {
            return numberTwo;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Начальные значения");
        outputOnDisplay();
        System.out.println("Задайте значения");
        System.out.println("Первое число");
        setChange1(UtilSimClassAndObj.numberInput());
        System.out.println("Второе число");
        setChange2(UtilSimClassAndObj.numberInput());
        System.out.println("Сумма чисел");
        System.out.println(sum(numOne, numTwo));
        System.out.println("Наибольшее из чисел");
        if (greatest(numOne, numTwo) == 0) {
            System.out.println("Числа равны");
        } else {
            System.out.println(greatest(numOne, numTwo));
        }
    }

}
