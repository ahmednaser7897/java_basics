package functionalProgramming.lambdaandmethodreference;

// A functional interface in Java is an interface that contains exactly one
// abstract method.
// It was introduced in Java 8 to support lambda expressions and method
// references.
@FunctionalInterface
interface DistanceCalculator {
    double calculateDistance(City city1, City city2);
    // If we add another abstract method here, the compiler will throw an error.
    // The @FunctionalInterface annotation is optional, but it's a good practice to
    // use it to ensure that the interface is indeed a functional interface.
    //double calculateDistanceByC(City city1, City city2, City city3);

    // Default methods are allowed in functional interfaces.
    default void someDefaultValue() {
    }

    static void someStaticMethod() {
    }
}
