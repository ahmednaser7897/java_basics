package basics;

import java.util.Scanner;

public class Selections {
    public static void main(String[] args) {
        conditionalOperator();
    }
    public static void booleanExample(){
        boolean isRaining = true;
        boolean b = (1 > 2);
        System.out.println("Is it raining? " + isRaining);
        System.out.println("Is 1 greater than 2? " + b);
        //Relational Operators
        System.out.println("Is 1 less than 2? " + (1 < 2));
        System.out.println("Is 1 less than 2? " + (1 > 2));
        System.out.println("Is 1 equal to 2? " + (1 == 2));
        System.out.println("Is 1 not equal to 2? " + (1 != 2));
        System.out.println("Is 1 greater than or equal to 2? " + (1 >= 2));
        System.out.println("Is 1 less than or equal to 2? " + (1 <= 2));
    }
    public static void ifElseExample(){
        boolean flag=3>4;
        if(flag){
            System.out.println("Flag is true");
        }else{
            System.out.println("Flag is false");
        }
        double score = 85.5;
        if (score >= 90.0)
            System.out.print("A");
        else if (score >= 80.0)
            System.out.print("B");
        else if (score >= 70.0)
            System.out.print("C");
        else if (score >= 60.0)
            System.out.print("D");
        else
        System.out.print("F");
    }
    public static void logicalOperatorsExample(){
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Receive an input
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        System.out.println("Is " + number + " divisible by 2 and 3? " +
                ((number % 2 == 0) && (number % 3 == 0)));

        System.out.println("Is " + number + " divisible by 2 or 3? " +
                ((number % 2 == 0) || (number % 3 == 0)));

        System.out.println("Is " + number +
                " divisible by 2 or 3, but not both? " +
                ((number % 2 == 0) ^ (number % 3 == 0)));
    }
    public static boolean method(){
        return true;
    }
    public static void logicalOperatorsExample2(){
        //in && operator the second operand is not evaluated if the first operand is false
        if (false && method()) {
            System.out.println("This will not be printed");
        }
        //in || operator the second operand is not evaluated if the first operand is true
        if (true || method()) {
            System.out.println("This will be printed");
        }
        //in & operator the second operand always evaluated
        if (true & method()) {
            System.out.println("This will not be printed");
        }
        //in | operator the second operand is always evaluated
        if (true | method()) {
            System.out.println("This will be printed");
        }
    }

    public static void switchStatements(){
        int id=0;
        switch (id){
            case 1:
                System.out.println("id is 1");
                break;
            case 2:
                System.out.println("id is 2");
                break;
            case 3:
                System.out.println("id is 3");
                break;
            case 4:
                System.out.println("id is 4");
                break;
            default:
                System.out.println("id is not 1 or 2 or 3 or 4");
        }
        int id2=2;
        switch (id2){
            case 1:
            case 2:
            case 3:
                System.out.println("id is 3");
                break;
            case 4:
                System.out.println("id is 4");
                break;
            default:
                System.out.println("id is not 1 or 2 or 3 or 4");
        }
    }
    static public void conditionalOperator()
    {
        int y=0;
        int x=0;
        if (x > 0)
            y = 1;
        else
            y = -1;
        System.out.println("Y is "+y);
        y = (x > 0) ? 2 : -2;
        System.out.println("Y is "+y);

    }
}
