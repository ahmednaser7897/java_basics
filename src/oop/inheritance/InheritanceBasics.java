package oop.inheritance;

import java.util.Date;

public class InheritanceBasics {
    public static void main(String[] args) {
        Circle circle = new Circle(10.0, "Red", true);
        // use method in the child class but we can use super keyword to access parent class method
        // so it override the parent class method
        System.out.println(circle.toString());
         //use function in the parent class 
        System.out.println("Is the circle filled?:"+circle.isFilled());
       
        Rectangle rectangle = new Rectangle(1.0, 2.0, "Blue", false);
        // use method in the child class but we can use super keyword to access parent class method
        // so it override the parent class method
        System.out.println(rectangle.toString());
        //use function in the parent class 
        System.out.println("Is the rectangle filled?:"+rectangle.isFilled());

        System.out.println("Example with default constructor");
        Circle circle2 = new Circle();
        System.out.println(circle2.toString());
        Rectangle rectangle2 = new Rectangle();
        System.out.println(rectangle2.toString());

        System.out.println("Example with one parameter constructor");
        Circle circle3 = new Circle(3.0);
        System.out.println(circle3.toString());

        System.out.println("Example with two parameter constructor");
        Rectangle rectangle3 = new Rectangle(3.0, 4.0);
        System.out.println(rectangle3.toString());

        System.out.println("Example test static methodes");
        //this will call the superclass static method
        Geometric.staticMethod();
        //this will call the subclass static method
        Circle.staticMethod();
        //this will call the subclass static method
        Rectangle.staticMethod();

        System.out.println("Example test overriding and overloading method");
        //this will call the child class method
        circle.testOverridingAndOverloading(1);
        //this will call the super class method
        rectangle.testOverridingAndOverloading(2);
        //this will call the child class method
        circle.testOverridingAndOverloading(1, 2);
        //this will make error because the child class does not have this method
        //rectangle.testOverridingAndOverloading(3, 4);
    }
}



