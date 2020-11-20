package aggregationAndComposition;

/*
2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться, менять колесо,
вывести на консоль марку автомобиля.
 */

import java.util.Scanner;

public class Car {
    private Wheel wheels[];
    private Engine engine;
    private String brand;
    private double consumption;
    private double fuelLevel;
    static double numInput;
    static String strInput;

    Car(Wheel wheels[], Engine engine, String brand, double consumption, double fuelLevel) {
        this.wheels = wheels;
        this.engine = engine;
        this.brand = brand;
        this.consumption = consumption;
        this.fuelLevel = fuelLevel;
    }

    void move() {
        if (fuelLevel <= 0) {
            System.out.println("Машина не может ехать, нет бензина");
            return;
        }
        for (int i = 0; i < wheels.length - 1; i++) {
            if (wheels[i].getDiameter() != wheels[i + 1].getDiameter()) {
                System.out.println("Машина не может ехать, колеса разного диаметра");
                System.out.println("Колесо " + (i + 1) + ":" + wheels[i + 1].getDiameter());
                return;
            }
        }

        double distance = fuelLevel / consumption;
        System.out.println("Закончился бензин");
        System.out.println("Машина проехала " + distance * 100 + "км.");
        fuelLevel = 0;
    }

    void addFuelLevel(double fuel) {
        fuelLevel += fuel;
    }

    public void change_wheel() {
        System.out.println("Введи номер колеса [0-3]:");
        int number;
        while (true) {
            number = (int) Car.numInput();
            if (number >= 0 && number <= 3)
                break;
            System.out.println("Неправильный номер, повтори ввод");
        }
        wheels[number] = Wheel.get();
    }

    static Car getCar() {
        Car car = new Car(new Wheel[4], new Engine(0), "", 0.0, 0.0);
        for (int i = 0; i < 4; i++) {
            System.out.println("Колесо " + i);
            car.wheels[i] = Wheel.get();
        }
        System.out.println("Введите обьем двигателя");
        car.engine = Engine.get();
        System.out.println("Введите бренд");
        car.brand = strInput();
        System.out.println("Введите расход топлива на 100км.");
        car.consumption = numInput();
        System.out.println("Введите текущий уровень топлива");
        car.fuelLevel = numInput();
        return car;
    }

    public String toString() {
        String string = "";
        string += "Бренд:" + brand + " Обьем двигателя:" + engine.getPower() + "; "
                + "Потребление: " + consumption + "L/100km { " + fuelLevel + " }; диаметр колес [";
        for (int i = 0; i < 4; ++i) {
            string += wheels[i].getDiameter() + " ";
        }
        return string + "]";
    }

    static double numInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            numInput = sc.nextDouble();
        } else {
            System.out.println("Неверный ввод");
            numInput();
        }
        return numInput;
    }

    static String strInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            strInput = sc.nextLine();
        } else {
            System.out.println("Неверный ввод");
            strInput();
        }
        return strInput;
    }
}

class Wheel {
    private double diameter;

    Wheel(double diameter) {
        this.diameter = diameter;
    }

    double getDiameter() {
        return diameter;
    }

    static Wheel get() {
        System.out.println("Введите диаметр колеса");
        Wheel wheel = new Wheel(0.0);
        wheel.diameter = Car.numInput();
        return wheel;
    }
}

class Engine {
    private double power;

    Engine(double power) {
        this.power = power;
    }

    double getPower() {
        return power;
    }

    static Engine get() {
        Engine engine = new Engine(0);
        engine.power = Car.numInput();
        return engine;
    }
}

class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Car car = Car.getCar();
        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. ехать\n" +
                            "2. заправляться\n" +
                            "3. менять колесо\n" +
                            "4. вывести информацию об авто (марку тоже)\n");
            int choice = scanner.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 4) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    car.move();
                    break;
                case 2:
                    System.out.println("Введи количество топлива:");
                    double fuel = Car.numInput();
                    car.addFuelLevel(fuel);
                    break;
                case 3:
                    car.change_wheel();
                    break;
                case 4:
                    System.out.println(car.toString());
                    break;
            }
        }
    }
}


