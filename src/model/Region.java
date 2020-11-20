package model;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private String regionName;
    private double square;
    private List<District> districts;

    public Region(String regionName) {
        this.regionName = regionName;
        this.districts = new ArrayList<>();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
