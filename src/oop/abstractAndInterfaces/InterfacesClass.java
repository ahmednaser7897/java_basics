package oop.abstractAndInterfaces;

import java.util.Arrays;
import java.util.Date;

public class InterfacesClass {
    public static void main(String[] args) {
        //testInterfaces();
        testComparableInterface();
    }
    public static void testInterfaces(){
        System.out.println("Test Interfaces");
        Object[] objects = {new Tiger(), new Chicken(), new Apple()};
        for (Object object : objects) {
            if (object instanceof Edible)
                System.out.println(((Edible) object).howToEat());

            if (object instanceof Animal) {
                System.out.println(((Animal) object).sound());
            }
        }

    }
    public static void testComparableInterface(){
        System.out.println("Test Comparable Interface");
        //arr wrapper class implement comparable interface
        System.out.println(Integer.valueOf(3).compareTo(new Integer(5)));
        System.out.println("ABC".compareTo("ABE"));
        Date date1 = new Date(2013, 1, 1);
        Date date2 = new Date(2012, 1, 1);
        System.out.println(date1.compareTo(date2));

        // we can use Arrays.sort to sort any class that implement comparable
        Circle2[] list={new Circle2(3),new Circle2(2),new Circle2(5)};
        Arrays.sort(list);
        for (Circle2 circle : list) {
            System.out.println(circle.getRadius());
        }
    }

}

abstract class Animal {
    /** Return animal sound */
    public abstract String sound();
}

class Chicken extends Animal implements Edible {
    @Override
    public String howToEat() {
        return "Chicken: Fry it";
    }

    @Override
    public String sound() {
        return "Chicken: cock-a-doodle-doo";
    }
}

class Tiger extends Animal {
    @Override
    public String sound() {
        return "Tiger: RROOAARR";
    }
}

abstract class Fruit implements Edible {
    // Data fields, constructors, and methods omitted here
}

class Apple extends Fruit {
    @Override
    public String howToEat() {
        return "Apple: Make apple cider";
    }
}

class Orange extends Fruit {
    @Override
    public String howToEat() {
        return "Orange: Make orange juice";
    }
}

class Circle2  implements  Comparable<Circle2>{
    private double radius;
    Circle2(double radius){
       this.radius=radius;
    }
    public double getArea() {return Math.PI * radius * radius;}
    public void setRadius(double radius) {this.radius = radius;}
    public double getRadius() {return radius;}
    @Override
    public int compareTo(Circle2 o) {
        return Double.compare(this.getArea(), o.getArea());
    }
}

