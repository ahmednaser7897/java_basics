package basics;
import java.util.Scanner;
public class Loops {
    public static void main(String[] args) {
        // whileLoop();
       // forLoop();
        //doWhileLoop();
       // nestedLoop();
        breakAndContinue();
    }
    public static void whileLoop(){
        System.out.println("While Loop");
        int count = 0;
        while (count <= 4) {
            System.out.format("Welcome to Java %d \n",count );
            count++;
        }
        Scanner scanner = new Scanner(System.in);
        int a1=(int)(Math.random() * 10);
        int b1=(int)(Math.random() * 10);
        System.out.format("Enter a the sum of %d and %d: \n",a1,b1);
        int number = scanner.nextInt();
        while (number!=a1+b1) {
            System.out.format(" %d is a wrong answer , try again\n",number );
            number = scanner.nextInt();
        }
        System.out.println("Correct answer");

        System.out.println("please guess a number between 0 and 100 , and -1 to end");
        int a2=(int)(Math.random() * 101);
        int number1 = scanner.nextInt();
        while (number1 !=a2) {
            if(number1==-1){
                System.out.println("end the operation");
                break;
            }
            if(number1 > a2) {
                System.out.println("Too high");
            } else {
                System.out.println("Too low");
            }
            number1 = scanner.nextInt();
        }
        if(number1 ==a2)
            System.out.println("Correct answer");
    }
    public static void forLoop(){
        System.out.println("For Loop");
        for (int i = 0; i < 5; i++) {
            System.out.format("Welcome to Java %d \n",i );
        }
    }
    public static void doWhileLoop(){
        System.out.println("Do while Loop");
        Scanner scanner = new Scanner(System.in);
        System.out.println("please guess a number between 0 and 100 , and -1 to end");
        int a2=(int)(Math.random() * 101);
        int number1 = scanner.nextInt();
      do {
            if(number1==-1){
                System.out.println("end the operation");
                break;
            }
            if(number1 > a2) {
                System.out.println("Too high");
            } else {
                System.out.println("Too low");
            }
            number1 = scanner.nextInt();
        }  while (number1 !=a2);
        if(number1 ==a2)
            System.out.println("Correct answer");
    }
    public static void nestedLoop(){
        System.out.println("Nested Loop");
        for (int i = 1; i <= 9; i++) {
            System.out.print("\t"+i);
        }
        System.out.println("\n-------------------------------------------");
        for (int i = 1; i <= 9; i++) {
            System.out.print((i)+" |"+"\t");
            for (int j = 1; j <=9; j++) {
                System.out.print(((i)*(j))+"\t");
            }
            System.out.println();
        }
    }
    public static void breakAndContinue(){
       for(int i=0;i<10;i++){
           if(i==4)
               continue;
           else if(i==8)
               break;
           System.out.println("i is "+i);
       }
    }
}
