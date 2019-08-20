package pro.sisit.javacourse.entity;

public class Transport {

    private String name;
    private double volume;
    private double cost;
    private RouteType type;

    public Transport(String name, double volume, double cost, RouteType type) {
        this.name = name;
        this.volume = volume;
        this.cost = cost;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public double getCost() {
        return cost;
    }

    public RouteType getType() {
        return type;
    }
}
