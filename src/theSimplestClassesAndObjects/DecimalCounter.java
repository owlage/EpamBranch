package theSimplestClassesAndObjects;

/*
5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в
заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее получить его текущее состояние.
Написать код, демонстрирующий все возможности класса.
 */

import java.util.Scanner;

public class DecimalCounter {

    int count;
    int min;
    int max;

    DecimalCounter() {
        min = 0;
        max = 10;
        count = 0;
    }

    DecimalCounter(int min, int max) {
        this.min = min;
        this.max = max;
        count = min;
    }

    void low() {
        count--;
        if (count < min) {
            count = max;
        }
    }

    void increase() {
        count++;
        if (count > max) {
            count = min;
        }
    }
}

class Program {

    static int num,number1,number2;

    static int numInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            num = sc.nextInt();
        } else {
            System.out.println("Введите цифру");
            numInput();
        }
        return num;
    }

    static char stringInput() {
        Scanner sc = new Scanner(System.in);
        char ch = 0;
        if (sc.hasNext()) {
            ch = sc.next().charAt(0);
        }
        return ch;
    }

    static Object obCounter() {
        System.out.println("Введите 0 если хотите задать значения счётчика по умолчанию" + "\n" +
                "Введите любую цифру и она будет проинициализирована как минимальное значение счётчика");
        number1 = numInput();
        if (number1 == 0) {
            DecimalCounter decimalCounter = new DecimalCounter();
            return decimalCounter;
        } else {
            System.out.println("Введите верхнюю границу счётчика");
            number2 = numInput();
            if (number1 >= number2) {
                System.out.println("Нижняя граница не может быть больше чем верхняя");
                obCounter();
            }
            DecimalCounter decimalCounter = new DecimalCounter(number1, number2);
            return decimalCounter;
        }
    }

    static int state(DecimalCounter decimalCounter) {
        return decimalCounter.count;
    }

    public static void main(String[] args) {
        DecimalCounter decimalCounter = (DecimalCounter) obCounter();
        System.out.println("Для того что бы узнать текущее состояние счётчика введите" + "\n" +
                '-' + " - уменшение счётчика" + "\n" +
                '+' + " - увеличение счётчика" + "\n" +
                '/' + " - выйти из программы" + "\n" +
                '=' + " - состояние счётчика");
        char operation = 0;
        while (operation != '/') {
            operation = stringInput();
            if (operation == '-') {
                decimalCounter.low();
                System.out.println("Значение счётчика после уменьшения = " + decimalCounter.count);
            }
            if (operation == '+') {
                decimalCounter.increase();
                System.out.println("Значение счётчика после увеличения = " + decimalCounter.count);
            }
            if (operation == '=') {
                System.out.println("Счётчик");
                System.out.println(state(decimalCounter));
            }
        }
    }
}


