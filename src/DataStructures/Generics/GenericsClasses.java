package DataStructures.Generics;

import oop.inheritance.Circle;
import oop.inheritance.Geometric;
import oop.inheritance.Rectangle;

import java.util.ArrayList;

public class GenericsClasses {
    static void main(String[] args) {
        genericsBasics();
        testStack();
        testGenericsMethode();
        testMaxClass();
    }

    public static void genericsBasics() {
        System.out.println("Generics Basics");
        // without generics
        ArrayList list1 = new ArrayList();
        list1.add("ahmed");
        list1.add(2);
        System.out.println(list1.toString());
        // with generics
        ArrayList<String> list = new ArrayList<>();
        list.add("ahmed");
        //list.add(2);
        System.out.println(list.toString());

        // this will case erorr on the run time
//        Comparable c1 = new Date();
//        c1.compareTo("name");
        // so its better to use generics to avoid errors in run time
        // and show this erorr in the compile time
        // this will case erorr on the compile time
        //Comparable<Date> c2=new Date();
        //c2.compareTo("name");

    }
    public static void testStack() {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("ahmed");
        stack.push("mohamed");
        stack.push("ali");
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.toString());
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
    }
    public static void testGenericsMethode(){
        System.out.println("Test Generics Methode");
        //Java generics only work with reference types (objects), not primitive types.
        Integer[] list={1,4,7,3,2};
        printList(list);

        Rectangle rectangle = new Rectangle(2, 2);
        Circle circle = new Circle (2);
        System.out.println("Same area? " +
                equalArea(rectangle, circle));
    }
   public static <E> void printList(E[] list) {
        for (E e : list) System.out.print(e + " ");
        System.out.println();
    }
    public static <E extends Geometric> boolean
    equalArea(E object1, E object2) {
        return object1.getArea() == object2.getArea();
    }
    public static void testMaxClass(){
        System.out.println("Test Max Class");
        //Raw Type is Unsafe
        // so it will not show error on compile time
        // but it will show error on run time
        //we did not specify the type of the objects
        // so it will not show error on compile time
        // but it will show error on run time
        //UnSaveMax.max("Welcome", 23); // No compile error

        //Safe Type is Safe
        // so it will show error on compile time
        // so it will not show error on run time
        // but it will show error on compile time
        //SaveMax.max("Welcome", 23); // compile error
        System.out.println("Max is "+SaveMax.max("Welcome", "Java"));
    }
}
