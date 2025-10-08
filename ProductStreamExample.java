import java.util.*;
import java.util.stream.*;

class Product {
    int id;
    String name;
    double price;
    String category;

    // Constructor
    Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Display method
    void display() {
        System.out.println(id + "  " + name + "  " + price + "  " + category);
    }
}

public class ProductStreamExample {
    public static void main(String[] args) {

        // Create product list
        List<Product> products = Arrays.asList(
                new Product(101, "Laptop", 75000, "Electronics"),
                new Product(102, "Mobile", 35000, "Electronics"),
                new Product(103, "T-shirt", 1200, "Clothing"),
                new Product(104, "Refrigerator", 48000, "Home Appliances"),
                new Product(105, "Shoes", 2500, "Clothing"),
                new Product(106, "Headphones", 2000, "Electronics")
        );

        System.out.println("All Products:");
        products.forEach(p -> p.display());

        // 1️⃣ Filter: Products priced above 5000
        System.out.println("\nProducts with Price > 5000:");
        products.stream()
                .filter(p -> p.price > 5000)
                .forEach(p -> p.display());

        // 2️⃣ Sort: Products by Price (Ascending)
        System.out.println("\nProducts Sorted by Price (Ascending):");
        products.stream()
                .sorted(Comparator.comparingDouble(p -> p.price))
                .forEach(p -> p.display());

        // 3️⃣ Sort: Products by Name (Alphabetically)
        System.out.println("\nProducts Sorted by Name:");
        products.stream()
                .sorted(Comparator.comparing(p -> p.name))
                .forEach(p -> p.display());

        // 4️⃣ Map: Get only product names
        System.out.println("\nProduct Names Only:");
        products.stream()
                .map(p -> p.name)
                .forEach(System.out::println);

        // 5️⃣ Aggregation: Count total number of Electronics products
        long electronicsCount = products.stream()
                .filter(p -> p.category.equalsIgnoreCase("Electronics"))
                .count();
        System.out.println("\nNumber of Electronics Products: " + electronicsCount);

        // 6️⃣ Aggregation: Find average price of all products
        double avgPrice = products.stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0.0);
        System.out.println("Average Price of All Products: " + avgPrice);
    }
}
