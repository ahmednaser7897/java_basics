package oop;

public class StringClass {
    public static void main(String[] args) {
        //StringClassBasics();
        //ReplacingAndSplittingStrings();
        testStringBuilder();
        testStringBuilderPerformance();
    }
    static void StringClassBasics(){
        System.out.println("String Class Basics");
        // string is a normal class that can be used to create objects
        String str = new String("Hello");
        System.out.println(str);
        String message = "Welcome to Java";
        System.out.println(message);

        //String are immutable
        // so this changes the reference with new one
        // not change the value of the object
        String s = "Java";
        System.out.println(s.hashCode());
        s = "HTML";
        System.out.println(s.hashCode());


        // so java uses Interned Strings  to save memory
        // and it is faster
        String s1 = "Java";
        String s2 = "Java";
        // == checks the reference
        //
        // so this will return true until we change the value of s1 or s2
        // so the reference will be different
        System.out.println(s1 == s2);
        // .equals() checks the value
        // so while the value is the same it will return true
        // hover it has the same reference or not
        System.out.println(s1.equals(s2));

        //but Interned Strings will not work if we use new keyword
        String s3 = new String("Java");
        String s4 = new String("Java");
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));


    }
    static void ReplacingAndSplittingStrings(){
        System.out.println("Replacing And Splitting Strings");
        System.out.println("Welcome".replace('e', 'A'));
        System.out.println("Welcome".replaceFirst("e", "AB"));
        System.out.println("Welcome".replace("e", "AB"));
        System.out.println("Welcome".replace("el", "AB") );
        String[] tokens = "Java#HTML#Perl".split("#", 0);
        for (String token : tokens) System.out.print(token + " ");
        System.out.println();
        //If the limit is positive then the pattern will be applied at most limit - 1 times
        //If the limit is zero then the pattern will be applied as many times as possible
        //If the limit is negative then the pattern will be applied as many times as possible and the array can have any length
        String[] tokens2 = "Java#HTML#Perl".split("#", 2);
        for (String token : tokens2) System.out.print(token + " ");
        System.out.println();
    }
    static void testStringBuilder(){
        System.out.println("Testing StringBuilder");
        // StringBuilder is mutable
        // so this changes the value of the object
        StringBuilder stringBuilder = new StringBuilder("Hello jav");
        stringBuilder.append("Java");
        stringBuilder.insert(11, "HTML and ");
        stringBuilder.delete(8, 11) ;
        stringBuilder.deleteCharAt(8);
        stringBuilder.reverse() ;
        stringBuilder.replace(11, 15, "HTML");
        stringBuilder.setCharAt(0, 'w') ;
        System.out.println(stringBuilder);
    }

    static void testStringBuilderPerformance(){
        System.out.println("Testing String Performance");
        //String are immutable
        // so this changes the reference with new one
        // not change the value of the object
        long startTime = System.currentTimeMillis();
        String s= "";
        for (int i = 0; i < 100000; i++) {
            s+=i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String Time taken: " + (endTime - startTime) + "ms");
        System.out.println();

        System.out.println("Testing StringBuilder Performance");
        // StringBuilder is mutable
        // so this changes the value of the object
        long startTime1 = System.currentTimeMillis();
        StringBuilder s1= new StringBuilder();
        for (int i = 0; i < 100000; i++) {
          s1.append(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("StringBuilder Time taken: " + (endTime1 - startTime1) + "ms");
    }

}
