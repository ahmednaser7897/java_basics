package basics;

public class MathFunctions {
    public static void main(String[] args) {
       // roundingMethods();
        randomFunction();
    }
    public static void roundingMethods(){
        double d1 = 5.2;
        double d2 = 5.5;
        double d3 = 5.8;

        System.out.format("d1 =%f  d2 =%f  d3 =%f  \n", d1,d2,d3);//5.2 5.5 5.8

        //ceiling function rounds up to the nearest integer
        System.out.println("Ceiling function");
        System.out.println("d1 =" + Math.ceil(d1));//6
        System.out.println("d2 =" + Math.ceil(d2));//6
        System.out.println("d3 =" + Math.ceil(d3));//6

        //floor function rounds down to the nearest integer
        System.out.println("floor function");
        System.out.println("d1 =" + Math.floor(d1));//5
        System.out.println("d2 =" + Math.floor(d2));//5
        System.out.println("d3 =" + Math.floor(d3));//5

        //round function rounds to the nearest integer
        System.out.println("round function");
        System.out.println("d1 =" + Math.round(d1));//5
        System.out.println("d2 =" + Math.round(d2));//6
        System.out.println("d3 =" + Math.round(d3));//6

        //rint function rounds to the nearest even integer
        System.out.println("rint function");
        System.out.println("d1 =" + Math.rint(d1));//5
        System.out.println("d2 =" + Math.rint(d2));//6
        System.out.println("d3 =" + Math.rint(d3));//6
    }
    public static void randomFunction(){
        //random function returns a double between 0.0 and 1.0
        System.out.println("Random function");
        double d = Math.random();
        System.out.println(d);

        //To generate a random double value between 0 - 10 or 0 - 100,
        //use the following expression: (int)(Math.random() * 10). 10 can be 100 or 1000 based on the requirement
        int d2 =(int)(Math.random() * 10);
        System.out.println(d2);
        //To generate a random double value between a - b or,
        //use the following expression: (int)(Math.random() * (b - a) + a)
        int d3 =(int)(Math.random() * (100 - 10) + 10);
        System.out.println(d3);
    }
}
