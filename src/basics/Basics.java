package basics;
//Implicit Import when we call all class in a package
//import java.util.*;
//Explicit Import when we call a specific class in a package
import java.util.InputMismatchException;
import java.util.Scanner;
//examples for ch1 and ch2
public class Basics {
    public static void main(String[] args) {
        CastingAugmentedExpression();
    }
    //how to take input from the user
    public static void computeArea(){
       try {
           Scanner scanner=new Scanner(System.in);
           System.out.print("Enter the radius : ");
           var radius= scanner.nextDouble();
           double area= Math.PI*Math.pow(radius,2);
           System.out.println("The area for the circle of radius "+ radius+" is "+area);
           // this is how can I formate a double number
           System.out.printf("The area for the circle of radius %.2f is %.4f%n", radius, area);
           System.out.format("The area for the circle of radius %.2f is %.4f%n", radius, area);
           // can use final variables as a const
           final double PI = 3.14159;
           double area2= PI*Math.pow(radius,2);
           System.out.format("The area for the circle of radius %.2f is %.4f%n", radius, area2);

       }catch (InputMismatchException e){
           System.out.println("You did not entered a valid number");
       }catch (Exception e){
           System.out.println("some thing went wrong");
       }
    }
    public  static  void  integerDivision(){
        // divide  two integers always yilds and integer
        System.out.println(5/2);//2
        //to solve this change any number to double
        System.out.println(5.0/2);//2.5
        System.out.println(5/2.0);//2.5
        //floating point arithmetics

        System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);//0.5000000000000001
        //The double type values are more accurate than the
        //float type values. For example,
        System.out.println("1.0 / 3.0 is " + 1.0 / 3.0);//0.3333333333333333
        System.out.println("1.0F / 3.0F is " + 1.0F / 3.0F);//0.33333334

    }
    public  static  void  typeCasting(){
        //range increases
        //byte, short, int, long, float, double
//        When performing a binary operation involving two
//        operands of different types, Java automatically
//        converts the operand based on the following rules:
//        1.    If one of the operands is double, the other is
//        converted into double.
//        2.    Otherwise, if one of the operands is float, the other is
//        converted into float.
//        3.    Otherwise, if one of the operands is long, the other is
//        converted into long.
//        4.    Otherwise, both operands are converted into int.
        //Implicit casting  conversion
        double d = 3;// (type widening)
        //Explicit casting
        int i = (int)3.14;// (type narrowing)
        System.out.println(i);
        //Implicit casting  conversion
        long l = 3L;// (type widening)
        //Explicit casting
        int i2 = (int)3.14;// (type narrowing)
        System.out.println(i2);

        //int x=5/2.5 //this will case error

    }

    public static void  decimalPoint(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter purchase amount: ");
        double purchaseAmount = input.nextDouble();

        double tax = purchaseAmount * 0.06;
        System.out.println("Sales tax is " +tax);
        System.out.println("Sales tax is " + (tax * 100) );
        System.out.println("Sales tax is " + (int)(tax * 100) );
        //this is how we can round off a double number to 2 decimal places
        System.out.println("Sales tax is " + (int)(tax * 100) / 100.0);
    }
    public static void  CastingAugmentedExpression(){
        int sum = 0;
        //you can do this
        //sum += 4.5; // sum becomes 4 after this statement
        sum += 4.5; //is equivalent to sum = (int)(sum + 4.5).
        System.out.println(sum);//4 it will truncate the decimal part
        //but you can  notdo this
        //sum = sum + 4.5;
       // System.out.println(sum);
    }
}





















