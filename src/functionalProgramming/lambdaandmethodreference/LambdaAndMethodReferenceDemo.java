package functionalProgramming.lambdaandmethodreference;

public class LambdaAndMethodReferenceDemo {
    public void main(String[] args) {
        useNormalImplementationTheInterface();
        sendInterfaceAnonymousClassImplementation();
        sendInterfaceLambdaImplementation();
        testMethodReference();
    }

    void useNormalImplementationTheInterface() {
        System.out.println("Using normal implementation of the interface");
        // Create an instance of OrderManagement with a default implementation
        OrderManagement orderManagement = new OrderManagement(new DefaultDistanceCalculator());

        // Create two cities
        City city1 = new City(0, 0);
        City city2 = new City(3, 4);

        // Calculate and print the distance
        System.out.println("Distance using normal implementation is "
                + orderManagement.getDistance(city1, city2));

    }

    void sendInterfaceAnonymousClassImplementation() {
        System.out.println("Using anonymous class to implement the interface");
        // we are using anonymous class to implement the interface
        // this is a verbose way to implement the interface
        OrderManagement orderManagement = new OrderManagement(new DistanceCalculator() {
            @Override
            public double calculateDistance(City city1, City city2) {
                return city1.getLatitude() - city2.getLatitude();
            }
        });

        // Create two cities
        City city1 = new City(0, 0);
        City city2 = new City(3, 4);

        // Calculate and print the distance
        System.out.println("Distance using anonymous class is "
                + orderManagement.getDistance(city1, city2));

    }

    void sendInterfaceLambdaImplementation() {
        System.out.println("Using lambda expression to implement the interface");
        // we are using lambda expression to implement the interface
        // this is a concise way to implement the interface
        // if its one statement no need for curly braces and return
        OrderManagement orderManagement1 = new OrderManagement(
                (city1, city2) -> city1.getLatitude() - city2.getLatitude());

        OrderManagement orderManagement2 = new OrderManagement(
                (city1, city2) -> {
                    System.out.println("Calculating distance using lambda expression");
                    return city1.getLatitude() - city2.getLatitude();
                });
        // Create two cities
        City city1 = new City(0, 0);
        City city2 = new City(3, 4);

        // Calculate and print the distance
        System.out.println("Distance using one statement lambda expression is "
                + orderManagement1.getDistance(city1, city2));
        System.out.println("Distance using multiple statements lambda expression is "
                + orderManagement2.getDistance(city1, city2));

    }

    void testMethodReference() {
        System.out.println("Using method reference to implement the interface");
        // we use this when we already have another method
        // that we want to use its implmantation instead of
        // creating a new concret class or rewrite the same logic using lambda
        // expression
        // we are using method reference to implement the interface
        // this is a concise way to implement the interface
        // -----------------------------------------------------
        // when i want to use static method i use class name
        // ClassName::staticMethod
        OrderManagement orderManagement1 = new OrderManagement(
                GoogleDistanceCalculator::getDistanceBetweenCitiesStatic);

        // -----------------------------------------------------
        // when i want to use instance method i use object name
        // objectName::instanceMethod
        GoogleDistanceCalculator googleDistanceCalculator = new GoogleDistanceCalculator();
        OrderManagement orderManagement2 = new OrderManagement(
                googleDistanceCalculator::getDistanceBetweenCities);
        // Create two cities
        City city1 = new City(0, 0);
        City city2 = new City(3, 4);

        // Calculate and print the distance
        System.out.println("Distance using static method reference is "
                + orderManagement1.getDistance(city1, city2));
        System.out.println("Distance using instance method reference is "
                + orderManagement2.getDistance(city1, city2));

    }
}

class OrderManagement {

    private DistanceCalculator distanceCalculator;

    public OrderManagement(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public void setDistanceCalculator(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public double getDistance(City city1, City city2) {
        return distanceCalculator.calculateDistance(city1, city2);
    }
}

class DefaultDistanceCalculator implements DistanceCalculator {

    @Override
    public double calculateDistance(City city1, City city2) {
        return 0;
    }

}

class GoogleDistanceCalculator {

    public double getDistanceBetweenCities(City city1, City city2) {
        return 1;
    }

    public static double getDistanceBetweenCitiesStatic(City city1, City city2) {
        return 1;
    }
}