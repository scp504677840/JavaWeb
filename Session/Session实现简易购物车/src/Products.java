import java.util.LinkedHashMap;

public class Products {

    private static LinkedHashMap<String, Product> products = new LinkedHashMap<>();

    static {
        products.put("1", new Product("1", "Java", 90.50, "Java Plus"));
        products.put("2", new Product("2", "C", 50.50, "C Plus"));
        products.put("3", new Product("3", "Kotlin", 55.50, "Kotlin Plus"));
        products.put("4", new Product("4", "Python", 60.50, "Python Plus"));
        products.put("5", new Product("5", "Go", 80.50, "Go Plus"));
    }

    private Products() {
    }

    public static LinkedHashMap<String, Product> getAll() {
        return products;
    }
}
