package aggregationAndComposition;

/*
 Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль столицу,
 количество областей, площадь, областные центры.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Country {
    static int numInput;
    static double doublInput;
    static String strInput;
    private Region region;
    String country, capital;
    private List<Region> regionsList = new ArrayList<>();

    Country(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    Country(List<Region> regionsList) {
        this.regionsList = regionsList;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public List getRegionList() {
        return regionsList;
    }

    static String strInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            strInput = sc.nextLine();
        } else {
            System.out.println("Недопустимый ввод");
            strInput();
        }
        return strInput;
    }

    static int numInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            numInput = sc.nextInt();
        } else {
            System.out.println("Недопустимый ввод");
            numInput();
        }
        return numInput;
    }

    static double doublInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            doublInput = sc.nextDouble();
        } else {
            System.out.println("Недопустимый ввод");
            doublInput();
        }
        return doublInput;
    }

    public Country addCountry() {
        Country country = new Country(null);
        country.regionsList.add(Region.addRegion());
        return country;
    }

}

