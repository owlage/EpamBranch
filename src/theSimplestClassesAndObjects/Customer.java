package theSimplestClassesAndObjects;

/*
8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод
toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.

Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.

Найти и вывести:

a) список покупателей в алфавитном порядке;

b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

    private int id;
    private static int ID;
    private String surname;
    private String name;
    private String ochestvo;
    private String address;
    private long numCreditCard;
    private long bankAccountNumber;
    static String strIn;
    static long integIn;

    Customer(String surname, String name, String ochestvo, String address, long numCreditCart, long bankAccountNumber) {
        id = ID++;
        this.surname = surname;
        this.name = name;
        this.ochestvo = ochestvo;
        this.address = address;
        this.numCreditCard = numCreditCart;
        this.bankAccountNumber = bankAccountNumber;
    }

    void setId(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    void setSurName(String surName) {
        this.surname = surName;
    }

    String getSurName() {
        return surname;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setOchestvo(String ochestvo) {
        this.ochestvo = ochestvo;
    }

    String getOchestvo() {
        return ochestvo;
    }

    void setAddress(String address) {
        this.address = address;
    }

    String getAddress() {
        return address;
    }

    void setNumCreditCart(long numCreditCart) {
        this.numCreditCard = numCreditCart;
    }

    long getNumCreditCard() {
        return numCreditCard;
    }

    void setBankAccountNumber(long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String toString() {
        return "id: " + getId() + "\n" + "Surname: " + getSurName() + "\n" + "Name: " + getName() + "\n" +
                "Otchestvo: " + getOchestvo() + "\n" + "Address: " + getAddress() + "\n" +
                "Num credit card: " + getNumCreditCard() + "\n" + "Bank account number: " +
                getBankAccountNumber() + "\n";
    }

    public void print() {
        System.out.println(toString());
    }

    static String strInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            strIn = sc.nextLine();
            strIn = strIn.replaceAll("[^А-Яа-я]", "");
        } else {
            System.out.println("Введите строку");
            strInput();
        }
        return strIn;
    }

    static String addressInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            strIn = sc.nextLine();
            strIn = strIn.replaceAll("[^А-Яа-я0-9]", "");
        } else {
            System.out.println("Введите строку");
            strInput();
        }
        return strIn;
    }

    static long number() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            integIn = sc.nextLong();
            int length = (int) (Math.log10(integIn) + 1);
            if (length != 16) {
                System.out.println("Введите 16 цифр");
                number();
            }
        } else {
            System.out.println("Введите 16 цифр");
            number();
        }
        return integIn;
    }

    public static Customer getCustomer() {
        Customer customer = new Customer("", "", "", "", 0, 0);
        System.out.println("Введите фамилию");
        customer.surname = strInput();
        System.out.println("Введите имя");
        customer.name = strInput();
        System.out.println("Введите отчество");
        customer.ochestvo = strInput();
        System.out.println("Введите адрес");
        customer.address = addressInput();
        System.out.println("Введите номер кредитной карты, 16 цифр");
        customer.numCreditCard = number();
        System.out.println("введите номер банковского счета, 16 цифр");
        customer.bankAccountNumber = number();

        return customer;
    }

    static class ByNameComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer left, Customer right) {
            if (left.surname != right.surname)
                return left.surname.compareTo(right.surname);
            if (left.name != right.name)
                return left.name.compareTo(right.name);
            return left.ochestvo.compareTo(right.ochestvo);
        }
    }
}
/*
создается новый массив, большего размера (в этом примере – в 2 раза большего);
в новый массив копируется содержимое старого массива;
происходит добавление элемента в новый массив обычным образом.
 */

class Customers {
    private Customer[] customers;
    private int capacity;
    private int size;

    public Customers(int capacity_) {
        size = 0;
        capacity = capacity_;
        customers = new Customer[capacity];
    }

    public Customers() {
        this(10);
    }

    public void push_back(Customer customer) {
        if (size < capacity) {
            customers[size] = customer;
            size++;
        } else {
            Customer[] buffer = new Customer[capacity * 2];
            for (int i = 0; i < size; ++i) {
                buffer[i] = customers[i];
            }
            customers = buffer;
            capacity = capacity * 2;
            customers[size] = customer;
            size++;
        }
    }

    public void print() {
        for (int i = 0; i < size; ++i) {
            customers[i].print();
        }
    }

    public void sortByName() {
        Arrays.sort(customers, 0, size, new Customer.ByNameComparator());
    }

    public void print_if_card_in(long a, long b) {
        for (int i = 0; i < size; ++i) {
            if (customers[i].getNumCreditCard() >= a && customers[i].getNumCreditCard() <= b)
                customers[i].print();
        }
    }
}


class Program {

    public static void main(String[] args) {
        ArrayList<Customer> arrayList = new ArrayList<>();
        Customers customers = new Customers();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выйти\n" +
                            "1. добавить покупателя\n" +
                            "2. вывод покупателей в алфавитном порядке\n" +
                            "3. вывод покупателей с кредитной картой в интервале\n");
            int choice = sc.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 3) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    customers.push_back(Customer.getCustomer());
                    break;
                case 2:
                    customers.sortByName();
                    customers.print();
                    break;
                case 3:
                    System.out.println("Введи диапазон кредитных карт\n");
                    System.out.println("От: ");
                    long a = Customer.number();
                    System.out.println("До: ");
                    long b = Customer.number();
                    customers.print_if_card_in(a, b);
            }
        }
    }

}



