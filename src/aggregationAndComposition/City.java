package aggregationAndComposition;

public class City {

    private String city;

    City(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

   static City addCity() {
        City city = new City("");
        System.out.println("Введите город");
        city.city = Country.strInput();
        return city;
    }
}
