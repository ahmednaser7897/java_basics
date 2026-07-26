package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerAndBiConsumer {
    public void main(String[] args) {
        createConsumer();
        createBiConsumer();
        testConsumer();
        testBiConsumer();
    }

    void createConsumer() {
        System.out.println("Create consumer");
        Consumer<String> consumer = str -> System.out.println(str.toUpperCase());
        ;
        consumer.accept("Hello");
        List<String> names = List.of(
                "Ahmed",
                "Ali",
                "Sara");
        // for each loop takes lambda expression as an argument
        // and its of type Consumer
        names.forEach(consumer);
    }

    void createBiConsumer() {
        System.out.println("Create BiConsumer");
        BiConsumer<String, Integer> student = (name, age) -> System.out.println(name + " " + age);

        student.accept("Ahmed", 22);

        // Example 2: we can use it to modify object state
        BiConsumer<Employee, Double> addBonus = (emp, bonus) -> emp.salary += bonus;
        Employee e = new Employee("Ali", 5000);

        addBonus.accept(e, 2000.0);

        System.out.println(e.salary);

        // Example 3: we can use it with mergeInTheMap
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Ahmed", 20);
        prices.put("Ali", 30);
        prices.put("Sara", 40);
        prices.put("Ahmed", 50);
        prices.merge("Ahmed", 200, (oldValue, newValue) -> oldValue + newValue);
        System.out.println(prices.get("Ahmed"));
        // for each loop takes lambda expression as an argument
        // and its of type BiConsumer when using it on map
        prices.forEach(
                (name, salary) -> System.out.println(name + " -> " + salary));
    }

    void testConsumer() {
        System.out.println("========== Consumer demo ==========");

        List<Product> products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Product 1", "Category 1", 99.99),
                new DefaultProduct(2, "Product 2", "Category 2", 149.99),
                new DefaultProduct(3, "Product 3", "Category 3", 39.99)));

        increasePriceForProductList(products, 10);
        for (Product product : products) {
            System.out.println(product);
        }

    }

    public static void increasePriceForProductList(List<? extends Product> products,
            double priceToIncrease) {
        products.iterator()
                .forEachRemaining(
                        product -> product.setPrice(product.getPrice()
                                + priceToIncrease));
    }

    void testBiConsumer() {
        System.out.println("========== BiConsumer demo ==========");
        Map<Integer, Product> idProductMap = new HashMap<>();
        idProductMap.put(1, new DefaultProduct(1, "Product 1", "Category 1", 99.99));
        idProductMap.put(2, new DefaultProduct(2, "Product 2", "Category 2", 149.99));
        idProductMap.put(3, new DefaultProduct(3, "Product 3", "Category 3", 39.99));

        increasePriceForProductMap(idProductMap, 10);
        for (Product product : idProductMap.values()) {
            System.out.println(product);
        }

    }

    public static void increasePriceForProductMap(Map<Integer, ? extends Product> idProductMap,
            double priceToIncrease) {
        idProductMap.forEach((id, product) -> product.setPrice(product.getPrice()
                + priceToIncrease));
    }

}

class Employee {

    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

}

interface Product {

    int getId();

    String getProductName();

    String getCategoryName();

    double getPrice();

    void setPrice(double price);
}

class DefaultProduct implements Product {

    private int id;
    private String productName;
    private String categoryName;
    private double price;

    public DefaultProduct() {
    }

    public DefaultProduct(int id, String productName, String categoryName, double price) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product id=" + id + ", product name=" + productName
                + ", category name=" + categoryName + ", price=" + price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

}
