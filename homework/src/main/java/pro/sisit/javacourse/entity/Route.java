package pro.sisit.javacourse.entity;

public class Route {

    private RouteType type;

    private double length;

    public Route(RouteType type, double length) {
        this.type = type;
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public RouteType getType() {
        return type;
    }
}
