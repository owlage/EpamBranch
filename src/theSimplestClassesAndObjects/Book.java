package theSimplestClassesAndObjects;

/*
9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод
toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.

Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.

Найти и вывести:

a) список книг заданного автора;

b) список книг, выпущенных заданным издательством;

c) список книг, выпущенных после заданного года.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Book {

    private int id;
    private static int ID;
    private String bookName;
    private String[] author;
    private String publishingHouses;
    private int theYearOfPublishing;
    private int pagesNumbers;
    private int price;
    private String binding;
    static String strIn;
    static int num;

    Book(String bookName, String[] author, String publishingHouses, int theYearOfPublishing, int pagesNumbers,
         int price, String binding) {
        id = ID++;
        this.bookName = bookName;
        this.author = author;
        this.publishingHouses = publishingHouses;
        this.theYearOfPublishing = theYearOfPublishing;
        this.pagesNumbers = pagesNumbers;
        this.price = price;
        this.binding = binding;
    }

    int getId() {
        return id;
    }

    void setBookName(String bookName) {
        this.bookName = bookName;
    }

    String getBookName() {
        return bookName;
    }

    String[] getAuthor() {
        return (String[]) author.clone();
    }

    void setPublishingHouses(String publishingHouses) {
        this.publishingHouses = publishingHouses;
    }

    String getPublishingHouses() {
        return publishingHouses;
    }

    void setTheYearOfPublishing(int theYearOfPublishing) {
        this.theYearOfPublishing = theYearOfPublishing;
    }

    int getTheYearOfPublishing() {
        return theYearOfPublishing;
    }

    void setPagesNumbers(int pagesNumbers) {
        this.pagesNumbers = pagesNumbers;
    }

    int getPagesNumbers() {
        return pagesNumbers;
    }

    void setPrice(int price) {
        this.price = price;
    }

    int getPrice() {
        return price;
    }

    void setBinding(String binding) {
        this.binding = binding;
    }

    String getBinding() {
        return binding;
    }

    public String toString() {
        return "id: " + getId() + "\nНазвание: " + getBookName() + "\nАвтор: " + Arrays.toString(author) +
                "\nИздательсво: " + getPublishingHouses() + "\nГод издатния: " + getTheYearOfPublishing() +
                "\nКол - во страниц " + getPagesNumbers() + "\nЦена: " + getPrice() + "\nПереплет: " + getBinding();
    }

    public void print() {
        System.out.println(toString());
    }

    static String strInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            strIn = sc.nextLine();
        } else {
            System.out.println("Введите строку");
            strInput();
        }
        return strIn;
    }

    static int numInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            num = sc.nextInt();
            if (num < 1) {
                System.out.println("Введите значение больше чем 0");
                numInput();
            }
        } else {
            System.out.println("Вы допустили ошибку ввода числа");
            numInput();
        }
        return num;
    }

    static int numYearInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            num = sc.nextInt();
            int length = (int) (Math.log10(num) + 1);
            if (length > 4) {
                System.out.println("Введите год из 4 цифр");
                numYearInput();
            }
        } else {
            System.out.println("Введите год из 4 цифр");
            numYearInput();
        }
        return num;
    }

    static Book getBook() {
        Book book = new Book("", null, "", 0, 0, 0,
                "");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги");
        book.bookName = strInput();
        System.out.println("Введите фамилию авторов через 'пробел'");
        String strAuthor = strInput();
        book.author = strAuthor.split(" ");
        System.out.println("Введите издательство");
        book.publishingHouses = strInput();
        System.out.println("Введите год издания");
        book.theYearOfPublishing = numYearInput();
        System.out.println("Введите кол-во страниц");
        book.pagesNumbers = numInput();
        System.out.println("Введите цену");
        book.price = numInput();
        System.out.println("Введите тип переплета");
        book.binding = strInput();
        return book;
    }
}

class Books {
    private Book[] books;
    private int size;
    private int capacity;

    Books(int capacity) {
        size = 0;
        this.capacity = capacity;
        books = new Book[capacity];
    }

    Books() {
        this(10);
    }

    void pushBooks(Book book) {
        if (size < capacity) {
            books[size] = book;
            size++;
        } else {
            Book[] buffer = new Book[capacity * 2];
            for (int i = 0; i < size; i++) {
                buffer[i] = books[i];
            }
            books = buffer;
            capacity = capacity * 2;
            books[size] = book;
            size++;
        }
    }

    void print() {
        for (int i = 0; i < size; i++) {
            books[i].print();
        }
    }

    void authorOutput(String str) {
        Book[] books1 = Arrays.copyOf(books, books.length);
        for (int i = 0; i < books1.length; i++) {
            for (String str1 : books1[i].getAuthor()) {
                if (str.equals(str1)) {
                    books1[i].print();
                }
            }
        }
    }

    void publishingHousesOutput(String str) {
        Book[] books2 = Arrays.copyOf(books, books.length);
        for (int i = 0; i < books2.length; i++) {
            if (str.equals(books2[i].getPublishingHouses())) {
                books2[i].print();
            }
        }
    }

    void yearOutput(int year) {
        Book[] books3 = Arrays.copyOf(books, books.length);
        for (int i = 0; i < books3.length; i++) {
            if (year == books3[i].getTheYearOfPublishing()) {
                books3[i].print();
            }
        }
    }
}


class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Books books = new Books(1);
        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выйти\n" +
                            "1. добавить книгу\n" +
                            "2. найти книги по автору\n" +
                            "3. найти книги по издательству\n" +
                            "4. найти книги после года издания" + "\n");
            int choice = Book.numInput();
            if (choice < 1 || choice > 4) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    books.pushBooks(Book.getBook());
                    break;
                case 2:
                    System.out.println("Введите автора");
                    String strAuthor = Book.strInput();
                    books.authorOutput(strAuthor);
                    break;
                case 3:
                    System.out.println("Введите название издательства");
                    String strPublishing = Book.strInput();
                    books.publishingHousesOutput(strPublishing);
                    break;
                case 4:
                    System.out.println("Введите год издания");
                    int year = Book.numYearInput();
                    books.yearOutput(year);
            }
        }
    }
}
