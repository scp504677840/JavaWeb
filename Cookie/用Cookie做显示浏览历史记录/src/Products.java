import java.util.LinkedHashMap;

public class Products {

    private static LinkedHashMap<String, Product> products = new LinkedHashMap<>();

    static {
        products.put("1", new Product("1", "Java", 99.50, "Java plus"));
        products.put("2", new Product("2", "C", 55.50, "C plus"));
        products.put("3", new Product("3", "Python", 35.50, "Python plus"));
        products.put("4", new Product("4", "Go", 20.50, "Go plus"));
    }

    private Products() {
    }

    public static LinkedHashMap<String, Product> getAll() {
        return products;
    }

}
