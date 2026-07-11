package oop;

import basics.Basics;

import java.util.Date;

public class OopBasics {
    public static  void main(String[] args) {
      // testOopBasics();
        //testTVClass();
        //testDateClass();
        testVisibilityModifiers();
    }
    static void testOopBasics(){
        // if no constructor is defined then default constructor is called
        // if now initialize the variables then it will be set by default
        // 0 or null
        Square s1=new Square();
        System.out.println(s1);

        //if we will not give it initial values it will be set by default
        Circle c1=new Circle();
        //use the initializing value
        System.out.println(c1);
        //use the method initializing value
        c1.setRadius(5);
        System.out.println(c1);
        //use the Constructor initializing value
        Circle c2=new Circle(3);
        System.out.println(c2);
    }
    static void testTVClass(){
        TV tv1=new TV();
        //we can call static variables using class name like TV.totalTVs or TV.maxVolume
        // this will give error because totalTVs is final so it can not be changed
        //TV.totalTVs=200;
        //this will not give error because maxVolume is not final
        TV.maxVolume=200;
        System.out.println(tv1);
        tv1.turnOn();
        System.out.println(tv1);
        tv1.setChannel(10);
        System.out.println(tv1);
        tv1.volumeUp();
        System.out.println(tv1);
        tv1.volumeDown();
        System.out.println(tv1);
        tv1.channelUp();
        System.out.println(tv1);
        tv1.channelDown();
        System.out.println(tv1);
        tv1.setVolume(150);
        System.out.println(tv1);
        tv1.setVolume(90);
        System.out.println(tv1);
        tv1.setChannel(100);
        System.out.println(tv1);
        tv1.turnOff();
        System.out.println(tv1);
        tv1.turnOn();
        System.out.println(tv1);
    }
    static void testDateClass(){
        Date date=new Date();
        System.out.println(date);
        System.out.println(date.toString());
        System.out.println(date.getTime());
    }
    static void testVisibilityModifiers(){
        //test visibility modifiers
        //1-Default :
        //By default, the class, variable, or method can be
        //accessed by any class in the same package.
        //Example: TestOop IS default and defaultTest() , x IS default so we can call it
        System.out.println("Test default modifier");
        TestOop testOop = new TestOop();
        System.out.println(testOop.x);
        testOop.defaultTest();
        // this will give error because Loops is default, but it is not in the same package
        //Loops Loops = new Loops();
        //Loops.whileLoop();


        //2-public
        //The class, data, or method is visible to any class in any package.
        //Example: Basics IS public and CastingAugmentedExpression IS public so we can call it
        System.out.println("Test public modifier");
        // not in the same package
        Basics.CastingAugmentedExpression();
        // in the same package
        System.out.println("Test public modifier");
        TestOop testOop2 = new TestOop();
        System.out.println(testOop2.y);
        testOop2.publicTest();
        // this will give error because Loops is not public
         //Loops Loops = new Loops();
        //Loops.whileLoop();

        //3-private
        //The data or methods can be accessed only by the declaring
        //class.
        System.out.println("Test private modifier");
        TestOop testOop3 = new TestOop();
        //this will give error because z , privateTest() is private
        //System.out.println(testOop3.z);
        //testOop3.privateTest();

        //protected


    }
}
 class Square{
    double side;
    public double getSide(){
        return side;
    }
    public  double getArea(){
        return side*side;
    }
    public  String toString(){
        return String.format("The area for the Square of side %.2f is %.4f%n",getArea(),getSide());
    }

}
class Circle{
    // we can set values of variables in constructor
    // or by method or in the initializing
    // or if we will not give it initial values it will be set by default
    double radius=1;
    Circle(){
        System.out.format("Circle default constructor called with radius = %.2f",radius);
        System.out.println();
    }
    Circle(double radius){
        this.radius=radius;
        System.out.format("Circle value constructor called with radius = %.2f",radius);
        System.out.println();
    }
   public void setRadius(double radius){
        if(radius>0)
            this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public  double getArea(){
        return radius*radius*Math.PI;
    }
    public  double perimeter(){
        return 2*Math.PI*radius;
    }
    public  String toString(){
        return String.format("The area for the circle of radius %.2f is %.4f%n",getArea(),getRadius());
    }
}
class TV{
    private int channel=1;
    private int volume=50;
    private boolean isOn=false;
    public final  static  int totalTVs=100;
    public  static  int maxVolume=100;

    TV(){}
    TV(int channel, int volume, boolean isOn){
        this.channel=channel;
        this.volume=volume;
        this.isOn=isOn;
    }
    void turnOn(){
        isOn=true;
    }
    void turnOff(){
        isOn=false;
    }
    void setChannel(int channel){
        if(isOn&&channel>0&&channel<=totalTVs)
            this.channel=channel;
    }
    void setVolume(int volume){
        if(isOn&&volume>0&&volume<=maxVolume)
            this.volume=volume;
    }
    void channelUp(){
        if(isOn&&volume<totalTVs)
            channel++;
    }
    void channelDown(){
        if(isOn&&volume>0)
            channel--;
    }
    void  volumeUp(){
        if(isOn&&volume<maxVolume)
            volume++;
    }
    void  volumeDown(){
        if(isOn&&volume>0)
            volume--;
    }
    public String toString(){
        return String.format("The channel is %d and the volume is %d and the isOn is %b",channel,volume,isOn);
    }
}
