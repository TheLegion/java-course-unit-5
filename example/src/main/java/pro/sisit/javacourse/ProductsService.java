package pro.sisit.javacourse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsService {

    public static void main(String[] args) {
    }

    List<ProductType> getUniqueProductTypes(List<Product> products) {
        return products.stream()
                       .map(product -> product.getType())
                       .distinct()
                       .collect(Collectors.toList());
    }

    List<Product> filterProductsByType(
        List<Product> products, ProductType type
    ) {
        return products.stream()
                       .filter(item -> item.getType() == type)
                       .collect(Collectors.toList());
    }

    double getProductPriceWithNDS(
        List<Product> products, long productId
    ) {
        return products
            .stream()
            .filter(p -> p.getId() == productId)
            .findFirst()
            .map(this::getPriceWithNDS)
            .orElseThrow(
                () -> new RuntimeException("Не найден такой товар")
            );
    }

    private double getPriceWithNDS(Product product) {
        double price = product.getPrice();
        return price * 1.2;
    }

}
