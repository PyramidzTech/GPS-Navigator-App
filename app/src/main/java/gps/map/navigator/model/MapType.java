package gps.map.navigator.model;

public @interface MapType {

    int NORMAL_DAY = 0;
    int NORMAL_NIGHT = 1;
    int SATELLITE_DAY = 2;
    int SATELLITE_NIGHT = 3;
    int TRAFFIC_DAY = 4;
    int TRAFFIC_NIGHT = 5;
}