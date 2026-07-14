package oop.abstractAndInterfaces;

public class AbstractClass {
    static void main(String[] args) {
        Geometric g = new Circle(1.0);
        System.out.println(g.getArea());
        System.out.println(g.getPerimeter());
        Geometric g1 = new Rectangle(1.0,1.0);
        System.out.println(g1.getArea());
        System.out.println(g1.getPerimeter());
        System.out.println(geometricEquals(g,g1));
    }
    public static boolean geometricEquals(Geometric geometric1,Geometric geometric2) {
        return geometric1.getArea() == geometric2.getArea() ;
    }
}
abstract class  Geometric{
    private  String color;
    Geometric(){
        // This calls the constructor of the same class -> this(arguments);
        this("White",false);
    }
    Geometric(  String color,
                boolean filled
    ){
        this.color = color;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public  String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String toString() {return "Geometric [color=" + color + "]";}

}
 class Circle extends Geometric {
    private double radius;
    Circle(){
        this(1.0);
    }
    Circle(double radius){
        setRadius(radius);
    }
    Circle(double radius, String color, boolean filled){
        super(color, filled);
        setRadius(radius);
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public double getRadius() {return radius;}
    public void setRadius(double radius) {
        if(radius>0)
            this.radius = radius;
        else
            this.radius = 0;
    }
    public double getDiameter() {return 2 * radius;}
    public String toString() {return super.toString() + " Circle [radius=" + radius + "]";}
}

class Rectangle extends Geometric {
    private  double width;
    private double height;
    Rectangle(){
        this(1.0,1.0);
    }
    Rectangle(double width, double height){
        super();
        setHeight(height);
        setWidth(width);
    }
    Rectangle(double width, double height, String color, boolean filled){
        super(color, filled);
        setHeight(height);
        setWidth(width);
    }
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    public void setWidth(double width) {
        if(width>0)
            this.width = width;
        else
            this.width = 0;
    }
    public double getWidth() {
        return width;
    }
    public void setHeight(double height) {
        if(height>0)
            this.height = height;
        else
            this.height = 0;
    }
    public double getHeight() {
        return height;
    }

    public String toString() {
        return super.toString() + " Rectangle [width=" + width + ", height=" + height + "]";
    }
}