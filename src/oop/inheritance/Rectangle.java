package oop.inheritance;

////subclasses
class Rectangle extends Geometric {
    private  double width;
    private double height;
    //By default this will add width = 0.0; and height = 0.0;
    //and will add default super(); at the begining of the constructor
    Rectangle(){
        this(1.0,1.0);
    }
    Rectangle(double width, double height){
        // This calls the constructor of the parent class -> super(arguments);
        // we do not need to call super() if we are calling the default constructor
        // because it will be called by default
        // but we need to call super() if we are calling the parameterized constructor
        // in the child class
        //super();
        super();
        setHeight(height);
        setWidth(width);
    }
    Rectangle(double width, double height, String color, boolean filled){
        // This calls the constructor of the parent class -> super(arguments);
        //here we have to call super() because we are calling the parameterized constructor
        // so if we didn't call super() with parameterized constructor then
        //  it will call default constructor
        //this call should be first line of the constructor
        super(color, filled);
        setHeight(height);
        setWidth(width);
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
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
    public String toString() {
        return super.toString() + " Rectangle [width=" + width + ", height=" + height + "]";
    }
}