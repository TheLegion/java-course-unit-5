package pro.sisit.javacourse.entity;

import java.util.List;

public class Delivery {

    private List<Route> routes;

    private double volume;

    private String name;

    public Delivery(String name, List<Route> routes, double volume) {
        this.name = name;
        this.routes = routes;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public double getVolume() {
        return volume;
    }
}
