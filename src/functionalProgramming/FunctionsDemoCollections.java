package functionalProgramming;

import java.util.*;
import java.util.function.*;

public class FunctionsDemoCollections {
    void main(String[] args) {
        createFunctionsClass();
        createBiFunctionsClass();
        testFunctionalBiFunctions();
        testFunctionalBiConsumer();
        useingComposeAndAndThen();
        testComposeAndAndThen();
    }

    void createFunctionsClass() {
        System.out.println("Testing Functions");
        // Function class takes T and returns R
        // and we assign it to a variable name that can describe the action of the
        // function
        // in this example T is String and R is Integer and the action is to get
        // the length of the string
        Function<String, Integer> getLength = String::length;
        System.out.println(getLength.apply("Ahmed"));

        Function<String, String> toUpper = str -> str.toUpperCase();
        System.out.println(toUpper.apply("java"));

        Function<Integer, Integer> square = n -> n * n;
        // we can store the result in a var
        var result = square.apply(5);
        System.out.println(result);

    }

    void createBiFunctionsClass() {
        System.out.println("Testing BiFunctions");
        // BiFunction class takes two arguments T and U and returns R
        // and we assign it to a variable name that can describe the action of the
        // function
        // in this example T is String and U is Integer and R is Integer and the
        // action is to get the length of the string
        BiFunction<String, Integer, Integer> getLength = (str, n) -> str.length() + n;
        System.out.println(getLength.apply("Ahmed", 10));

        BiFunction<String, String, String> toUpper = (str, str2) -> str.toUpperCase() + str2.toUpperCase();
        System.out.println(toUpper.apply("java", "python"));

        BiFunction<Integer, Integer, Integer> square = (n, m) -> n * m;
        var result = square.apply(5, 10);
        System.out.println(result);
    }

    void testFunctionalBiFunctions() {
        System.out.println("Function and BiFunctions test");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println("========== Function type demo ==========");
        System.out.println("map.get(4): " + map.get(4));
        // this is a function in the Map Interface (java.util.Map) called
        // computeIfAbsent
        // it takes a key and a Function<K, V>
        // if the key is not present in the map it will compute the value using the
        // Function<K, V>
        // and put the key and the value in the map
        // this is ueing lambda expression
        map.computeIfAbsent(4, key -> Integer.toString(key));
        System.out.println("map.get(4): " + map.get(4));
        // this is using method reference
        map.computeIfAbsent(5, FunctionsDemoCollections::convertIntToString);
        System.out.println("map.get(5): " + map.get(5));

        System.out.println("========== BiFunction type demo ==========");
        // this is a bi function in the Map Interface (java.util.Map) called
        // computeIfPresent
        // it takes a key and a BiFunction<K, V , R>
        // if the key is present in the map it will compute the value using the
        // BiFunction<K, V , R>
        // and put the key and the value in the map
        // this is ueing lambda expression
        map.computeIfPresent(3, (key, value) -> key + " : " + value);
        System.out.println("map.get(3): " + map.get(3));
        // this is using method reference
        map.computeIfPresent(2, FunctionsDemoCollections::combineIntAndString);
        System.out.println("map.get(2): " + map.get(2));
    }

    public static String convertIntToString(Integer integer) {
        return Integer.toString(integer);
    }

    public static String combineIntAndString(Integer integer, String string) {
        return integer + " : " + string;
    }

    // this example will use the forEach method which is a higher order function in
    // the Map interface
    // it takes a BiConsumer<K, V>
    // and it will iterate over the map and apply the BiConsumer to each key-value
    // pair
    void testFunctionalBiConsumer() {
        System.out.println("BiConsumer type demo");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        // this is using lambda expression
        map.forEach((key, value) -> System.out.println(key + " : " + value));
        // this is using method reference
        map.forEach(FunctionsDemoCollections::printKeyValue);
    }

    public static void printKeyValue(Integer key, String value) {
        System.out.println(key + " : " + value);
    }

    void useingComposeAndAndThen() {
        System.out.println("Testing compose And andThen functions");
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;
        // and then means apply the function that called the andThen method first
        // then apply the function in the argument
        // f.andThen(g) - > g(f(x)) -> function f is applied first and result is
        // passed to g
        // ---------------------------------------------------------
        // 5
        // → multiplyBy2 = 10
        // → add3 = 13
        Function<Integer, Integer> result = multiplyBy2.andThen(add3);
        System.out.println(result.apply(5));
        // --------------------------------------------------------
        // compose means apply the function in the argument first
        // then apply the function that called the compose method
        // f.compose(g) -> f(g(x)) -> function g is applied first and result is
        // passed to f
        // --------------------------------------------------------
        // 5
        // → add3 = 8
        // → multiplyBy2 = 16
        Function<Integer, Integer> result2 = multiplyBy2.compose(add3);
        System.out.println(result2.apply(5));

    }

    private static final double DISCOUNT_RATE = 0.05;

    void testComposeAndAndThen() {
        System.out.println("Testing compose And andThen functions");
        System.out.println("========== Compose Functions type demo ==========");
        Map<Product, Double> productDiscountMap = new HashMap<>();

        List<Product> products = new ArrayList<>(Arrays.asList(new Product(1, 199.99),
                new Product(2, 79.99),
                new Product(3, 49.99)));

        for (Product product : products) {
            Function<Product, Double> getPriceFunction = Product::getPrice;
            Function<Double, Double> getDiscountFunction = price -> price * DISCOUNT_RATE;
            Function<Product, Double> getPriceAndThenDiscountFunction = getPriceFunction.andThen(getDiscountFunction);

            Function<Product, Double> getPriceAndThenDiscountFunction2 = getDiscountFunction.compose(getPriceFunction);

            productDiscountMap.computeIfAbsent(product, getPriceAndThenDiscountFunction);
        }
        System.out.println("========== Comparator.comparing() demo ==========");
        products.sort(Comparator.comparing(Product::getPrice));
        products.sort(Comparator.comparing(product -> product.getPrice()));
        System.out.println(products);


    }
}

class Product {
    private int id;
    private double price;

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", price=" + price + "]";
    }
}
