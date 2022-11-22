package org.example.pojo;

/**
 * @author mzy
 */
public class Plateau {
    private int upperRight_X;
    private int upperRight_Y;
    private boolean[] north_border;
    private boolean[] east_border;
    private boolean[] south_border;
    private boolean[] west_border;
    private String beacon_flag;

    public Plateau() {
    }

    public Plateau(int upperRight_X, int upperRight_Y) {
        this.upperRight_X = upperRight_X;
        this.upperRight_Y = upperRight_Y;
    }

    public String getBeacon_flag() {
        return beacon_flag;
    }

    public void setBeacon_flag(String beacon_flag) {
        this.beacon_flag = beacon_flag;
    }

    public boolean[] getNorth_border() {
        return north_border;
    }

    public void setNorth_border(boolean[] north_border) {
        this.north_border = north_border;
    }

    public boolean[] getEast_border() {
        return east_border;
    }

    public void setEast_border(boolean[] east_border) {
        this.east_border = east_border;
    }

    public boolean[] getSouth_border() {
        return south_border;
    }

    public void setSouth_border(boolean[] south_border) {
        this.south_border = south_border;
    }

    public boolean[] getWest_border() {
        return west_border;
    }

    public void setWest_border(boolean[] west_border) {
        this.west_border = west_border;
    }

    public int getUpperRight_X() {
        return upperRight_X;
    }

    public void setUpperRight_X(int upperRight_X) {
        this.upperRight_X = upperRight_X;
    }

    public int getUpperRight_Y() {
        return upperRight_Y;
    }

    public void setUpperRight_Y(int upperRight_Y) {
        this.upperRight_Y = upperRight_Y;
    }
}
