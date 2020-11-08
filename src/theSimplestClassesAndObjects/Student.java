package theSimplestClassesAndObjects;

/*
3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость
(массив из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий
 и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

import java.util.Scanner;

public class Student {

    int number;
    String surname;
    int numGroup;
    int[] performance = new int[5];

    Student() {
        surname = UtilSimplClassAndObj.strInput();
        System.out.println("Введите группу" + " студента");
        numGroup = numberInput();
        System.out.println("Введите успеваемость " + " студента, через enter");
        for (int j = 0; j < performance.length; j++) {
            performance[j] = numberInput();
        }
    }

    int numberInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            number = sc.nextInt();
            if (number > 10) {
                System.out.println("Не больше 10");
                numberInput();
            }
        } else {
            System.out.println("Введите целое число");
            numberInput();
        }
        return number;
    }
}

class Program {

    public static void main(String[] args) {


        Student[] array = new Student[10];
        int numStud = 1;
        for (int i = 0; i < array.length; i++) {//заполняем обьект данными
            System.out.println("Введите фамилию и инциалы " + numStud++ + " - го" + " студента. (кирилица)");
            array[i] = new Student();
        }
        int temp = 0; //счётчик студентов с баллами 9 и 10, если таких нет, то программа сообщит
        for (int i = 0; i < array.length; i++) {
            boolean bool = true;
            for (int j = 0; j < array[i].performance.length; j++) {
                if (array[i].performance[j] < 9) {
                    bool = false;
                }
            }
            if (bool) {
                temp++;
                System.out.println("ФИО студента");
                System.out.println(array[i].surname);
                System.out.println("№ группы");
                System.out.println(array[i].numGroup);
                System.out.println("Оценки");
                for (int appraisal : array[i].performance) {
                    System.out.print(appraisal + " ");
                }
                System.out.println();
            }
        }
        if(temp == 0){
            System.out.println("Нет студентов с баллами 9 и 10");
        }
    }
}

