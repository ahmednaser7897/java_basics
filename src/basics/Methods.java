package basics;

public class Methods {
    public static void main(String[] args) {
        System.out.println("sum is "+sumBetween(5,3));
        //java pass by value so x is not changed
        int x=10;
        System.out.println("x1 is "+x);
        increment(x);
        System.out.println("x2 is "+x);
        //to test normal method overloading so function call
        // is based on arguments only not return type
        System.out.println("2 double int is "+max(5,3));
        System.out.println("2 double max is "+max(5.5,3.2));
        System.out.println("3 double max is "+max(5.5,3.2,4.5));
        //to test ambiguous invocation
        //this will throw error because java cannot decide which function to call
        // because both 5,3 can be double or int
       // System.out.println("sum is "+sum(5,3));
        //so to make it work i must specify  the type of one of them
        System.out.println("sum is "+sum(5,3d));
        System.out.println("sum is "+sum(5d,3));
    }
    public static int sumBetween(int a1,int a2){
        if(a1>a2){
            int temp=a1;
            a1=a2;
            a2=temp;
        }
        int sum=0;
        for (int i=a1 ;i<=a2;i++){
          sum+=i;
        }
        return sum;
    }
    //to test call by value
    public static int increment(int a){
        a++;
        System.out.println("a is "+a);
        return a;
    }
    //to test normal method overloading
    public static int max(int a,int b  ){
        return a>b? a:b;
    }
    public static double max(double a,double b  ){
        return a>b? a:b;
    }
    public static double max(double a,double b,double c  ){
        return max(max(a,b),c);
    }
    //Ambiguous Invocation
    public static double sum(int num1, double num2) {
        return num1 + num2;
    }
    public static double sum(double a, int b) {
        return a + b;
    }
    //It is wrong to declare i in
    //two nesting blocks
    //    public static void method2() {
    //        int i = 1;
    //        int sum = 0;
    //        for (int i = 1; i < 10; i++) {
    //            sum += i;
    //        }
    //    }
    //t is fine to declare i in two
    //non-nesting blocks
    public static void method1() {
        int x = 1;
        int y = 1;
        for (int i = 1; i < 10; i++) {
            x += i;
        }
        for (int i = 1; i < 10; i++) {
            y += i;
        }
    }
}

