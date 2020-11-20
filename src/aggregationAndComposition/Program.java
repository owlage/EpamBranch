package aggregationAndComposition;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Country country = new Country(Country.strInput(), Country.strInput());
        while (true) {
            System.out.println("Выберите команду:\n" +
                    "0 - выход\n" +
                    "1 - добавить область\n" +
                    "2 - вывести на консоль столицу\n" +
                    "3 - количество областей\n" +
                    "4 - площадь\n" +
                    "5 - областные центры");

            int choice = Country.numInput();
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Повторите ввод");
                continue;
            }
            switch (choice) {
                case 1:
                    country.addCountry();
                    break;
                case 2:
                    System.out.println("Страна: " + country.getCountry());
                    System.out.println("Столица: " + country.getCapital());
                    break;
                case 3:
                    System.out.println("Кол - во областей: " + country.getRegionList().size());
                    break;
                case 4:
                    //System.out.println("Площадь всех областей: " + country.squareRegions());
            }
        }
    }
}
