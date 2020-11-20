import model.*;

import java.util.Scanner;

public class Program {
    private Country country;

    public static void main(String[] args) {
        new Program().showMenu();
    }


    private void showMenu() {
        System.out.println("Ввудите название страны и столицу через enter");
        Scanner sc = new Scanner(System.in);

        Country country = new Country(sc.nextLine(), sc.nextLine());

        while (true) {
            System.out.println("Выберите команду:\n" +
                    "0 - выход\n" +
                    "1 - заполнить страну областями\n" +
                    "2 - вывести на консоль столицу\n" +
                    "3 - количество областей\n" +
                    "4 - площадь\n" +
                    "5 - областные центры");

            int choice = sc.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Повторите ввод");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Введите название области");

                    country.getRegions().add(new Region(sc.nextLine()));

                    break;
                case 2:
                    System.out.println("Страна: " + country.getCountryName());
                    System.out.println("Столица: " + country.getCapitalName());
                    break;
                case 3:
                    System.out.println("Кол - во областей: " + country.getRegions().size());
                    break;
                case 4:
                    //System.out.println("Площадь всех областей: " + country.squareRegions());
            }
        }
    }
}
