package theSimplestClassesAndObjects;

/*
10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод
toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.

Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.

Найти и вывести:

a) список рейсов для заданного пункта назначения;

b) список рейсов для заданного дня недели;

c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Airline {

    private String pointOfDelivery, aircraftType;
    private String[] daysOfTheWeek;
    private int flightNumber;
    private double time;
    static String str;
    static int num;
    static double numDoubl;

    Airline(String pointOfDelivery, int flightNumber, String aircraftType, double time, String[] daysOfTheWeek) {
        this.pointOfDelivery = pointOfDelivery;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.time = time;
        this.daysOfTheWeek = daysOfTheWeek;
    }

    String getPointOfDelivery() {
        return pointOfDelivery;
    }

    int getFlightNumber() {
        return flightNumber;
    }

    String getAircraftType() {
        return aircraftType;
    }

    double getTime() {
        return time;
    }

    String[] getDaysOfTheWeek() {
        return (String[]) daysOfTheWeek.clone();
    }

    public String toString() {
        return "Пункт назначения: " + getPointOfDelivery() +
                "\nНомер рейса: " + getFlightNumber() +
                "\nТип самолета: " + getAircraftType() +
                "\nВремя вылета: " + getTime() +
                "\nДни недели: " + Arrays.toString(getDaysOfTheWeek());
    }

    public void print() {
        System.out.println(toString());
    }

    static Airline getAirline() throws ParseException {
        Airline airline = new Airline("", 0, "", 0.0, null);
        System.out.println("Введите пункт назначения");
        airline.pointOfDelivery = strInput();
        System.out.println("Введите номер самолета");
        airline.flightNumber = numInput();
        System.out.println("Введите тип самолета");
        airline.aircraftType = strInput();
        System.out.println("Введите время отправления через ','.Формат: 12,25");
        airline.time = numDoublInput();
        System.out.println("Введит дни недели отправления самолета, через пробел");
        airline.daysOfTheWeek = strInput().split(" ");
        return airline;
    }

    static String strInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            str = sc.nextLine();
        } else {
            System.out.println("Недопустимый ввод");
            strInput();
        }
        return str;
    }

    static int numInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            num = sc.nextInt();
        } else {
            System.out.println("Недопустимый ввод");
            numInput();
        }
        return num;
    }

    static double numDoublInput() throws ParseException {
        Scanner sc = new Scanner(System.in);
        DecimalFormat dF = new DecimalFormat("#00.00");
        if (sc.hasNextDouble()) {
            numDoubl = sc.nextDouble();
            str = dF.format(numDoubl);
            numDoubl = dF.parse(str).doubleValue();
            if (numDoubl >= 24.00) {
                System.out.println("Вы превысили временной порог");
                numDoublInput();
            }
        } else {
            System.out.println("Недопустимый ввод");
            numDoublInput();
        }
        return numDoubl;
    }
}

class Airlines {

    private Airline[] airlines;
    private int size;
    private int capacity;

    Airlines(int capacity) {
        size = 0;
        this.capacity = capacity;
        airlines = new Airline[capacity];
    }

    Airlines() {
        this(10);
    }

    void pushAirlines(Airline airline) {
        if (size < capacity) {
            airlines[size] = airline;
            size++;
        } else {
            Airline[] buffer = new Airline[capacity * 2];
            for (int i = 0; i < size; i++) {
                buffer[i] = airlines[i];
            }
            airlines = buffer;
            capacity = capacity * 2;
            airlines[size] = airline;
            size++;
        }
    }

    void pointSearch(String point) {
        int length = airlines.length;
        Airline [] arr = Arrays.copyOf(airlines, length);
        for (int i = 0; i < arr.length; i++) {
            if (point.equalsIgnoreCase(arr[i].getPointOfDelivery())) {
                airlines[i].print();
            }
        }
    }

    void daySearch(String day) {
        for (int i = 0; i < airlines.length; i++) {
            for (String str : airlines[i].getDaysOfTheWeek()) {
                if (str.equalsIgnoreCase(day)) {
                    airlines[i].print();
                }
            }
        }
    }

    void dayAndTimeSearch(String day, double time) {
        for (int i = 0; i < airlines.length; i++) {
            for (String str : airlines[i].getDaysOfTheWeek()) {
                if (str.equalsIgnoreCase(day)) {
                    if (airlines[i].getTime() >= time) {
                        airlines[i].print();
                    }
                }
            }
        }
    }
}

class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Airlines airlines = new Airlines(1);
        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выйти\n" +
                            "1. добавить рейс\n" +
                            "2. найти список рейсов по пункту назначения\n" +
                            "3. найти список рейсов по дню недели\n" +
                            "4. найти список рейсов по дню недели и времени" + "\n");
            int choice = Airline.numInput();
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    airlines.pushAirlines(Airline.getAirline());
                    break;
                case 2:
                    System.out.println("Введите пункт назначения");
                    String strPoint = Airline.strInput();
                    airlines.pointSearch(strPoint);
                    break;
                case 3:
                    System.out.println("Введите день недели");
                    String day = Airline.strInput();
                    airlines.daySearch(day);
                    break;
                case 4:
                    System.out.println("Введите день недели и через enter введите время через ','. Формат: 12,25");
                    String day1 = Airline.strInput();
                    double time = Airline.numDoublInput();
                    airlines.dayAndTimeSearch(day1, time);
            }
        }
    }
}

