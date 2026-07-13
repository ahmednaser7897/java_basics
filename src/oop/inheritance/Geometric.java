package oop.inheritance;

import java.util.Date;

//Superclasses
class Geometric{
    private  String color;
    private boolean filled;
    private final Date dateCreated;
    Geometric(){
        // This calls the constructor of the same class -> this(arguments);
        this("White",false);
    }
    Geometric(  String color,
                boolean filled
    ){
        this.color = color;
        this.filled = filled;
        this.dateCreated = new Date();
    }
    public  String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public  boolean isFilled() {return  filled;}
    public void setFilled(boolean filled) {this.filled = filled;}
    public Date getDateCreated() {return dateCreated;}
    public String toString() {return "Geometric [color=" + color + ", filled=" + filled + ", dateCreated=" + dateCreated + "]";}
    public static void staticMethod(){
        System.out.println("Static method of Geometric class");
    }
    public void testOverridingAndOverloading(int number){
        System.out.println("Geometric Test Overriding And Overloading method " + number);
    }
}