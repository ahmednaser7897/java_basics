package oop.inheritance;

import basics.Basics;
import oop.TestProtectedClass;

public class ProtectedModifier extends TestProtectedClass {
    public  void main(String[] args) {
        testVisibilityModifiers();
    }
     void testVisibilityModifiers(){
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

        //4-protected
        //A protected data or a protected method in a public class can be accessed
        //by any class in the same package or its subclasses,
        //even if the subclasses are in a different package.
        // its look like default but it can access by subclasses in different packages
        super.protectedTest();
         System.out.println(w+" is protected");

    }
}
