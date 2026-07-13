package oop.inheritance;


//subclasses
class Circle extends Geometric{
    private double radius;
    // By defau this will add radius = 0.0; in constructor
    // and will add default super(); at the begining of the constructor
    Circle(){
        // This calls the constructor of the same class -> this(arguments);
        this(1.0);
    }
    Circle(double radius){
        // This calls the constructor of the parent class -> super(arguments);
        // we do not need to call super() if we are calling the default constructor
        // because it will be called by default
        // but we need to call super() if we are calling the parameterized constructor
        // in the child class
        //super();
        setRadius(radius);
    }
    Circle(double radius, String color, boolean filled){
        // This calls the constructor of the parent class -> super(arguments);
        //here we have to call super() because we are calling the parameterized constructor
        // so if we didn't call super() with parameterized constructor then
        //  it will call default constructor
        //this call should be first line of the constructor
        super(color, filled);
        setRadius(radius);
    }
    public double getRadius() {return radius;}
    public void setRadius(double radius) {
        if(radius>0)
            this.radius = radius;
        else
            this.radius = 0;
    }
    public double getArea() {return Math.PI * radius * radius;}
    public double getPerimeter() {return 2 * Math.PI * radius;}
    public double getDiameter() {return 2 * radius;}
    public String toString() {return super.toString() + " Circle [radius=" + radius + "]";}

    public static void staticMethod(){
        //call static method of parent class is not possible
        // because static method belongs to the class not the object
        // so we use super keyword to call static method of parent class
        // but it will not work if the parent class is not a superclass
        // so static methodes can not be overridden
        // it will work as the superclass static method is not exist
        //super.staticMethod();
        System.out.println("Static method of Circle class");
    }


    //we can override non-static methods of parent class
    // so we will reimplement this method for circle class
    //and the chail will see this method in child class only in the use of it
    @Override
    public void testOverridingAndOverloading(int number) {
        // TODO Auto-generated method stub
        System.out.println("Circle Test Overriding And Overloading method " + number);
    }


    //overloadinh method
    //we can overload methods in child class
    //so the child class will have more than one testOverridingAndOverloading method
    //and the chail will see this method in child class also
    //and if we want to call the parent class method we can use super.testOverridingAndOverloading(number);
    public void testOverridingAndOverloading(int number, int number2) {
        // TODO Auto-generated method stub
        System.out.println("Circle Test Overriding And Overloading method " + number + " and " + number2);
    }
}