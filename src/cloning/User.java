package cloning;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// this is a stub class for the sake of the demo
public class User {

}

interface Product extends Serializable {

    int getId();

    String getProductName();

    String getCategoryName();

    double getPrice();

    void setPrice(double price);
}

interface ProductManagementService {

    List<Product> getProducts();

    Product getProductById(int productIdToAddToCart);

}

interface ProductStoringService {

    List<Product> loadProducts();

}

class DefaultProductManagementService implements ProductManagementService {

    private static DefaultProductManagementService instance;

    private static List<Product> products;

    private static ProductStoringService productStoringService;

    static {
        productStoringService = new DefaultProductStoringService();
        loadProductsFromStorage();
    }

    public static void loadProductsFromStorage() {
        products = productStoringService.loadProducts();
    }

    /**
     * @deprecated use loadProductsFromStorage instead
     */
    private static void initProducts() {
        products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
                new DefaultProduct(2, "Oregon Cottage Interior Oak Door", "Doors", 179.99),
                new DefaultProduct(3, "Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
                new DefaultProduct(4, "4 Panel Oak Deco Interior Door", "Doors", 209.09),
                new DefaultProduct(5, "Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller",
                        "Boilers", 989.99),
                new DefaultProduct(6, "Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
                new DefaultProduct(7, "Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers",
                        859.99),
                new DefaultProduct(8,
                        "Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)",
                        "Bricks", 402.99),
                new DefaultProduct(9, "Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)",
                        "Bricks", 659.99),
                new DefaultProduct(10, "Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks",
                        523.99)));
    }

    private DefaultProductManagementService() {

    }

    public static ProductManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultProductManagementService();
        }
        return instance;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int productIdToAddToCart) {
        for (Product product : products) {
            if (product != null && product.getId() == productIdToAddToCart) {
                return product;
            }
        }
        return null;
    }

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

class DefaultProductStoringService implements ProductStoringService {

    private static final String PRODUCTS_INFO_STORAGE = "products.csv";
    private static final String CURRENT_TASK_RESOURCE_FOLDER = "finaltask";
    private static final String RESOURCES_FOLDER = "resources";
    private static final int PRODUCT_PRICE_INDEX = 3;
    private static final int PRODUCT_CATEGORY_INDEX = 2;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int PRODUCT_ID_INDEX = 0;

    @Override
    public List<Product> loadProducts() {
        try (var stream = Files.lines(Paths.get(RESOURCES_FOLDER, CURRENT_TASK_RESOURCE_FOLDER,
                PRODUCTS_INFO_STORAGE))) {
            return stream
                    .filter(Objects::nonNull)
                    .filter(line -> !line.isEmpty())
                    .map(line -> {
                        String[] productElements = line.split(",");
                        return new DefaultProduct(Integer.valueOf(productElements[PRODUCT_ID_INDEX]),
                                productElements[PRODUCT_NAME_INDEX],
                                productElements[PRODUCT_CATEGORY_INDEX],
                                Double.valueOf(productElements[PRODUCT_PRICE_INDEX]));
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}