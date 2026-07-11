package oop;

public class WrapperClasses {
    public static void main(String[] args) {
        testIntegerClasses();
    }
    static void testIntegerClasses(){
        //can make it like this using contractor
        Integer i1 = new Integer(10);
        //can make it like this using autoboxing
        Integer i2 =  10;
        System.out.println(i1);
        System.out.println(i1.toString());
        System.out.println(i1.doubleValue());
        Integer i3 = Integer.valueOf("123");
        //UnBoxing
        System.out.println(i3);
        Integer i4 = new Integer("123");
        int x= Integer.parseInt("123");
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(i1.toString());
        System.out.println(i1.toString());
        //Boxing
        Integer[] intArray = {2, 4, 3};
        //UnBoxing
        System.out.println(intArray[0] + intArray[1] + intArray[2]);

    }
}
