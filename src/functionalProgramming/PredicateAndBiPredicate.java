package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateAndBiPredicate {
    void main(String[] args) {
        createPredicate();
        createBiPredicate();
        predicateFunctionDemo();
        testPredicate();
    }

    void createPredicate() {
        System.out.println("Create predicate");
        Predicate<Integer> predicate = number -> number % 2 == 0;
        System.out.println(predicate.test(10));
        List<Integer> numbers = List.of(3, 5, 7, 10, 15, 20);
        // it's predicate which we use in filter method in stream API
        numbers.stream()
                .filter(number -> number > 10)
                .forEach(System.out::println);
    }

    void createBiPredicate() {
        System.out.println("Create BiPredicate");
        BiPredicate<Integer, Integer> biPredicate = (number1, number2) -> number1 % number2 == 0;
        System.out.println(biPredicate.test(10, 2));
        BiPredicate<String, String> equals = (a, b) -> a.equals(b);

        System.out.println(equals.test("Java", "Java"));
        System.out.println(equals.test("Java", "Python"));
    }

    void predicateFunctionDemo() {
        Predicate<Integer> isEven = number -> number % 2 == 0;
        Predicate<Integer> isGreaterThan10 = number -> number > 10;
        // and
        Predicate<Integer> isEvenAndGreaterThan10 = isEven.and(isGreaterThan10);
        System.out.println(isEvenAndGreaterThan10.test(8));// false
        System.out.println(isEvenAndGreaterThan10.test(20));// true
        // or
        Predicate<Integer> isEvenOrGreaterThan10 = isEven.or(isGreaterThan10);
        System.out.println(isEvenOrGreaterThan10.test(8));// true
        System.out.println(isEvenOrGreaterThan10.test(20));// true
        // negate
        Predicate<Integer> isNotEven = isEven.negate();
        System.out.println(isNotEven.test(8));// false
        System.out.println(isNotEven.test(20));// false
        // not
        Predicate<String> isNotEmpty = Predicate.not(str -> str.isEmpty());
        System.out.println(isNotEmpty.test("Java"));// true
        System.out.println(isNotEmpty.test(""));// false
        // isEqual
        Predicate<String> equalToJava = Predicate.isEqual("Java");

        System.out.println(equalToJava.test("Java"));
        System.out.println(equalToJava.test("Python"));

    }

    void testPredicate() {

        System.out.println("========== Predicate demo ==========");

        List<Product> products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Product 1", "Category 1", 99.99),
                new DefaultProduct(2, "Product 2", "Category 2", 149.99),
                new DefaultProduct(3, "Product 3", "Category 3", 39.99)));

        removeProductsIfPriceIsMoreThan(products, 100);

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("========== Predicate.and() demo ==========");

        removeProductsIfPriceIsMoreThanAndCategoryIsEqualTo(
                products,
                90,
                "Category 1");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("========== Predicate.isEqual() demo ==========");
        List<User> users = new ArrayList<>(Arrays.asList(
                new UserForHashTables(1, "John", "Smith",
                        "password", "john.smith@email.com"),
                new UserForHashTables(2, "Ivan", "Ivanov",
                        "password", "ivan.ivanov@email.com"),
                new UserForHashTables(3, "Harsha", "Anand",
                        "password", "john.smith@email.com")));

        User criteriaUser = new UserForHashTables(1, "John", "Smith",
                "password", "john.smith@email.com");

        users.removeIf(Predicate.not(Predicate.isEqual(criteriaUser)));
        System.out.println(users);
    }

    public static void removeProductsIfPriceIsMoreThan(List<? extends Product> products,
            double price) {
        products.removeIf(product -> product.getPrice() > price);
    }

    public static void removeProductsIfPriceIsMoreThanAndCategoryIsEqualTo(
            List<? extends Product> products,
            double price,
            String categoryName) {
        Predicate<Product> isPriceIsMoreThanPredicate = product -> product.getPrice() > price;
        Predicate<Product> isCategoryIsEqualTo = product -> product.getCategoryName().equals(categoryName);
        products.removeIf(isPriceIsMoreThanPredicate.and(isCategoryIsEqualTo));

        // negate() demo
        // products.removeIf(isPriceIsMoreThanPredicate.and(isCategoryIsEqualTo).negate());
    }
}

interface User {

    String getFirstName();

    String getLastName();

    String getPassword();

    String getEmail();

    int getId();

    void setPassword(String newPassword);

    void setEmail(String newEmail);

}

class UserForHashTables implements User {

    private static int userCounter = 0;

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    {
        id = ++userCounter;
    }

    public UserForHashTables() {
    }

    public UserForHashTables(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public UserForHashTables(int id, String firstName, String lastName, String password, String email) {
        this.id = id;
        userCounter--; // to keep sequantial id
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + "\t\t" +
                "First Name: " + this.getFirstName() + "\t\t" +
                "Last Name: " + this.getLastName() + "\t\t" +
                "Email: " + this.getEmail();
    }

    @Override
    public void setPassword(String password) {
        if (password == null) {
            return;
        }
        this.password = password;
    }

    @Override
    public void setEmail(String newEmail) {
        if (newEmail == null) {
            return;
        }
        this.email = newEmail;
    }

    @Override
    public int getId() {
        return this.id;
    }

    void clearState() {
        userCounter = 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, id, lastName, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserForHashTables other = (UserForHashTables) obj;
        return Objects.equals(email, other.email)
                && Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(password, other.password);
    }

}