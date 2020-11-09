package theSimplestClassesAndObjects;

/*
4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива
по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами назначения должны
быть упорядочены по времени отправления.
 */


import java.util.*;

public class Train {

    String destination;
    int numTrain;
    String time;

    Train(String destination, int numTrain, String time) {
        this.destination = destination;
        this.numTrain = numTrain;
        this.time = time;
    }

    public static class sortingDestination implements Comparator<Train> {
        @Override
        public int compare(Train one, Train two) {
            //сделал такое решение т.к. one.time.compareTo(two.time) не работает
            if (one.destination == two.destination) {
                String str1 = one.time.replaceAll("[^0-9]", "");//записываем в строку только числа
                String str2 = two.time.replaceAll("[^0-9]", "");
                Integer time1 = Integer.parseInt(str1);//строку чисел записываем в Integer
                Integer time2 = Integer.parseInt(str2);
                return time1.compareTo(time2);
            }
            return one.destination.compareTo(two.destination);
        }
    }
}

class Program {
    //сортировка по номеру поезда
    static void sortingByVolume(Train[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].numTrain > array[j + 1].numTrain) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = (Train) temp;
                }
            }
        }
        for (Train o : array) {
            System.out.println("Место прибытия: " + o.destination + "; Номер поезда: " + o.numTrain +
                    "; Время отправления: " + o.time);
        }
    }

    static int numInput() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        if (sc.hasNextInt()) {
            num = sc.nextInt();
            if (num < 0) {
                System.out.println("число не может быть отрицательным");
                numInput();
            }
        } else {
            System.out.println("Введите целое число");
            numInput();
        }
        return num;
    }

    static void numTrain(Train[] array) {
        int temp = 0;
        int numTrain = numInput();
        for (Train o : array) {
            if (o.numTrain == numTrain) {
                temp++;
                System.out.println("Данные о поезде");
                System.out.println("Место прибытия: " + o.destination + "; Номер поезда: " + o.numTrain +
                        "; Время отправления: " + o.time);
            }
        }
        if (temp == 0) {
            System.out.println("Такого поезда нет, введите номер другого поезда");
            numTrain(array);
        }
    }

    public static void main(String[] args) {

        Train[] trains = new Train[5];
        trains[0] = new Train("Москва", 123, "13:00");
        trains[1] = new Train("Питер", 231, "9:00");
        trains[2] = new Train("Минск", 395, "4:27");
        trains[3] = new Train("Москва", 314, "2:15");
        trains[4] = new Train("Киев", 105, "19:00");
        System.out.println("Начальные обьекты");
        for (Train train : trains) {
            System.out.println("Место прибытия: " + train.destination + "; Номер поезда: " + train.numTrain +
                    "; Время отправления: " + train.time);
        }
        while (true) {
            System.out.println("Выберете пункт меню:" + "\n" +
                    "1. сортировка по номерам поездов" + "\n" +
                    "2. вывод информации о поезде по номеру" + "\n" +
                    "3. сортировка по пункту назначения" + "\n" +
                    "0. выход" + "\n");
            int numCommand = numInput();
            if (numCommand == 0) {
                break;
            }
            switch (numCommand) {
                case 1:
                    sortingByVolume(trains);
                    break;
                case 2:
                    System.out.println("Введите номер поезда");
                    numTrain(trains);
                    break;
                case 3:
                    Arrays.sort(trains, new Train.sortingDestination());
                    for (Train o : trains) {
                        System.out.println("Место прибытия: " + o.destination + "; Номер поезда: " + o.numTrain +
                                "; Время отправления: " + o.time);
                    }
                    break;
                default:
                    System.out.println("Такой команды нет, повторите ввод");
                    continue;
            }
        }
    }
}
