package aggregationAndComposition;

import java.util.ArrayList;
import java.util.List;

public class District {

    private String district;
    private City city;
    private List<City> cityList = new ArrayList<>();

    District(String district, City city) {
        this.district = district;
        cityList.add(city);

    }

    public String getDistrict() {
        return district;
    }

    static District addDistrict() {
        District district = new District("", null);
        System.out.println("Введите райной");
        district.district = Country.strInput();
        district.cityList.add(City.addCity());
        return district;
    }
}
