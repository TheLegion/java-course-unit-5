package javacourse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import pro.sisit.javacourse.PathFinder;
import pro.sisit.javacourse.entity.Delivery;
import pro.sisit.javacourse.entity.Route;
import pro.sisit.javacourse.entity.RouteType;
import pro.sisit.javacourse.entity.Transport;

public class TestPathFinder {

    private Transport GAZelle = new Transport("Газель", 10, 100, RouteType.Road);
    private Transport Plane = new Transport("Самолет", 100, 5000, RouteType.Air);
    private Transport Tanker = new Transport("Танкер", 2000, 10000, RouteType.Sea);
    private Transport Train = new Transport("Поезд", 2000, 1000, RouteType.Railway);
    private Transport SemiTrailerTruck = new Transport("Фура", 50, 200, RouteType.Road);

    private List<Transport> getAvailableTransport() {
        return Arrays.asList(GAZelle, Plane, Tanker, Train, SemiTrailerTruck);
    }

    @ParameterizedTest
    @ArgumentsSource(TestGetOptimalTransportArguments.class)
    void testGetOptimalTransport(Delivery delivery, Transport expected) {
        PathFinder pathFinder = new PathFinder();
        Transport optimalTransport = pathFinder.getOptimalTransport(delivery, getAvailableTransport());
        Assertions.assertEquals(expected, optimalTransport);
    }

    static class TestGetOptimalTransportArguments implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                new Object[]{getApplesDelivery(), null},
                new Object[]{getSmartphoneDelivery(), null},
                new Object[]{getCarsDelivery(), null}
            ).map(Arguments::of);
        }

        private Delivery getCarsDelivery() {
            return new Delivery(
                "Автомобили",
                Arrays.asList(
                    new Route(RouteType.Air, 2000),
                    new Route(RouteType.Sea, 2500),
                    new Route(RouteType.Road, 4000),
                    new Route(RouteType.Railway, 3000)
                ),
                4000);
        }

        private Delivery getSmartphoneDelivery() {
            return new Delivery(
                "Смартфоны",
                Arrays.asList(
                    new Route(RouteType.Air, 2000),
                    new Route(RouteType.Sea, 2500),
                    new Route(RouteType.Road, 4000)
                ),
                400
            );
        }

        private Delivery getApplesDelivery() {
            return new Delivery(
                "Яблоки",
                Arrays.asList(new Route(RouteType.Road, 1000.0), new Route(RouteType.Air, 700.0)),
                100.0
            );
        }
    }

}
