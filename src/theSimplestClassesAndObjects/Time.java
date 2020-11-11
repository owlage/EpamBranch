package theSimplestClassesAndObjects;

/*
6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и изменения
его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае недопустимых значений
полей поле устанавливается в значение 0. Создать методы изменения времени на заданное количество часов, минут и секунд.
 */

import java.util.Scanner;

public class Time {

    int hh, mm, sec;

    Time(int hh, int mm, int sec) {
        this.hh = hh;
        this.mm = mm;
        this.sec = sec;
    }

    Time() {
        this(0, 0, 0);
    }

    public void set_hh(int hh) {
        if (hh < 0 || hh > 23) {
            this.hh = 0;
        } else {
            this.hh = hh;
        }
    }

    public void set_mm(int mm) {
        if (mm < 0 || mm > 59) {
            this.mm = 0;
        } else {
            this.mm = mm;
        }
    }

    public void set_ss(int ss) {
        if (ss < 0 || ss > 59) {
            sec = 0;
        } else {
            sec = ss;
        }
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hh, mm, sec);
    }

    public void add_seconds(int ss_) {
        sec += ss_;
        mm += sec / 60;
        sec = sec % 60;
        hh += mm / 60;
        mm = mm % 60;
        hh = hh % 24;
    }

    public void add_minutes(int mm_) {
        add_seconds(mm_ * 60);
    }

    public void add_hours(int hh_) {
        add_seconds(hh_ * 60 * 60);
    }
}

class Program {

    static int num;

    static int numInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            num = sc.nextInt();
        } else {
            System.out.println("Введите число");
        }
        return num;
    }

    static Time timeInput() {
        System.out.println("Введите команду:" + "\n"
                + "'1' - Текущее время" + "\n"
                + "'2' - Установить время");
        Time time = null;
        int num = numInput();
        boolean bool = true;
        while (bool) {
            switch (num) {
                case 1:
                    time = new Time();
                    time.print();
                    bool = false;
                    break;
                case 2:
                    System.out.println("Введите часы:");
                    int hh = numInput();
                    System.out.println("Введите минуты");
                    int mm = numInput();
                    System.out.println("Введите секунды");
                    int sec = numInput();
                    time = new Time();
                    time.set_hh(hh);
                    time.set_mm(mm);
                    time.set_ss(sec);
                    time.print();
                    bool = false;
                    break;
                default:
                    System.out.println("Введите команду");
                    continue;
            }
        }
        return time;
    }

    static Time time(Time time) {
        boolean bool = true;
        while (bool) {
            System.out.println("Выберите что хотите прибавить" + "\n"
                    + "'1' - часы" + "\n" + "'2' - минуты" + "\n" + "'3' - секунды" + "\n" + "'0' - выход");
            num = numInput();
            switch (num) {
                case 1:
                    System.out.println("Введите кол - во часов");
                    time.add_hours(numInput());
                    System.out.print("Время: ");
                    time.print();
                    break;
                case 2:
                    System.out.println("Введите кол - во минут");
                    time.add_minutes(numInput());
                    System.out.print("Время: ");
                    time.print();
                    break;
                case 3:
                    System.out.println("Введите кол - во секунд");
                    time.add_seconds(numInput());
                    System.out.print("Время: ");
                    time.print();
                    break;
                case 0:
                    System.out.print("Время: ");
                    time.print();
                    bool = false;
                    break;
                default:
                    System.out.println("Выберите команду");
                    continue;
            }
        }
        return time;
    }



    public static void main(String[] args) {
        time(timeInput());
    }
}





