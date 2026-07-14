package oop.inheritance;

import java.util.Objects;

public class PolymorphismBasics {
    public  void main(String[] args) {
    //     testPolymorphismBasics();
    //     objectCasting();
    //    testPolymorphismDynamicBinding();
       testEqualsMethod();
    }
    public void testPolymorphismBasics(){
        System.out.println("Polymorphism Basics");
        //Polymorphism means that a variable of a supertype
        //can refer to a subtype object.
        //can say that Circle is a subtype of
        //GeometricObject and GeometricObject is a
        //supertype for Circle.
        //so we can use Geometric object to refer to a Circle object
        Geometric object2 = new Circle(10.0, "Red", true);
        displayOpject(object2);
    }
    public void displayOpject(Geometric object){
        System.out.println(object.toString());

    }
    public void objectCasting(){
        System.out.println("Primitive Variables Casting");
        //primitive variables casting:
        int a = 10;
        double b = 10.10;
        System.out.println("base values: a="+a+" b="+b);
        //implicit casting : when we assign a value of a smaller type to a larger type
        b = a;
        System.out.println("implicit casting : a="+a+" b="+b);
        //explicit casting : when we assign a value of a larger type to a smaller type
        a = (int) b;
        System.out.println("explicit casting : a="+a+" b="+b);

        System.out.println("Object Casting");
        //object casting : 
        // implicit object casting : when we assign a value of an object to its supertype variable
         Geometric object = new Circle();
        System.out.println(object.toString());

        // explicit object casting : when we assign a value of a supertype variable to an object
        Circle circle = (Circle) object;
        System.out.println(circle.toString());
        
    }
    public void testPolymorphismDynamicBinding(){
        Object student = new GraduateStudent();
        Object object = new Object();
        if(object instanceof  GraduateStudent){
            System.out.println("Never get here");
            GraduateStudent graduateStudent = (GraduateStudent) object;
        }

        System.out.println("Polymorphism Dynamic Binding");
        polymorphismDynamicBinding(new GraduateStudent());
        polymorphismDynamicBinding(new Student());
        polymorphismDynamicBinding(new Person());
        //Object is the root class of all classes in java
        //so this will print Object.toString() 
        polymorphismDynamicBinding(new Object());
    }
    public static void polymorphismDynamicBinding(Object x) {
        System.out.println(x.toString());
    }
    public void testEqualsMethod(){
        System.out.println("equals method test");
        // the equals method by default uses the == operator to compare objects
        // so it dose not compare the values of the objects
        // it compares the refrance of the objects
        // unless you override it
        Person1 person = new Person1("John");
        Person1 person2 = new Person1("John");
        //this will return true because it compares the values of the objects
        // becouse we override the equals method
        System.out.println(person.equals(person));

        Fruit fruit = new Fruit("Apple");
        Fruit fruit2 = new Fruit("Apple");
        // this will return false because we did not override the equals method in Fruit class
        // so it will use the default equals method from Object class
        // which compares the refrance of the objects
        System.out.println(fruit.equals(fruit2));

        //equals method with strings 
        String str1 = "Hello";
        String str2 = "Hello";
        //this will return true because it compares the values of the objects
        // becouse java override the equals method in the String class
        System.out.println(str1.equals(str2));
        
       
    }
   
}
// this has no toString method
// so this will print its parent (Student) super.toString() 
class GraduateStudent extends Student {
}
//this has its own toString method
//and it will override the parent (Person) toString method
class Student extends Person {
    public String toString() {
        return "Student";
    }
}
//this has its own toString method
//and it will override the parent (Object) toString method
class Person {
    public String toString() {
        return "Person";
    }
}
class Person1 {
    private String name;
    public Person1(String name){
        this.name = name;
    }
    public String toString() {
        return "Person";
    }
    // override equals method
    //we need to check if the object is an instance of Person1 class
    //then we compare the name of the objects
    @Override
    public boolean equals(Object other){
        if(other instanceof Person1){
            return Objects.equals(this.name, ((Person1) other).name);
        }
        return false;
    }
}
class Fruit {
    private String name;
    public Fruit(String name){
        this.name = name;
    }
}