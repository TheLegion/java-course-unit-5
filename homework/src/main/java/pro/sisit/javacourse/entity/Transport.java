package pro.sisit.javacourse.entity;

public class Transport {

    private String name;
    private double volume;
    private double price;
    private RouteType type;

    public Transport(String name, double volume, double price, RouteType type) {
        this.name = name;
        this.volume = volume;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public double getPrice() {
        return price;
    }

    public RouteType getType() {
        return type;
    }
}
