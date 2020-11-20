package model;

/*
 Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль столицу,
 количество областей, площадь, областные центры.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Country {
    private String countryName;
    private String capitalName;
    private List<Region> regions;

    public Country(String countryName, String capitalName) {
        this.countryName = countryName;
        this.capitalName = capitalName;
        regions = new ArrayList<>();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}

