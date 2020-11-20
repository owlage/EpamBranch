package aggregationAndComposition;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private String region;
    private double square;
    private District district;
    private List<District> districtsList = new ArrayList<>();


    Region(String region, double square, District district) {
        this.region = region;
        this.square = square;
        districtsList.add(district);
    }

    public String getRegion() {
        return region;
    }

    public double getSquare() {
        return square;
    }

    static Region addRegion() {
        Region region = new Region("", 0, null);
        System.out.println("Введите область");
        region.region = Country.strInput();
        System.out.println("Введите площадь в км2");
        region.square = Country.doublInput();
        region.districtsList.add(District.addDistrict());
        return region;
    }
}
