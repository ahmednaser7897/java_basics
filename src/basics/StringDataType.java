package basics;

public class StringDataType {
    public static void main(String[] args) {
        stringBasic();
        comparingStrings();
        obtainingSubstrings();
        stringsToNumbers();
        formatStrings();
    }
    public static void stringBasic(){
        String message = "Welcome to Java";
        System.out.println(message);
        System.out.println("message.length is "+message.length());
        //this will not change the original string
        System.out.println("concat  "+message.concat(" World"));
        System.out.println(message);
        System.out.println("message.toLowerCase is "+message.toLowerCase());
        System.out.println("message.toUpperCase is "+message.toUpperCase());
        System.out.println("message.trim is "+"  Welcome  ".trim());
        System.out.println("string concat");
        String str1 = "Hello";
        String str2 = "World";
        System.out.println(str1 + " " + str2);
        // Three strings are concatenated
        String message2 = "Welcome " + "to " + "Java";
        System.out.println(message2);
        // String Chapter is concatenated with number 2
        String s = "Chapter" + 2; // s becomes Chapter2
        System.out.println(s);
        // String Supplement is concatenated with character B
        String s1 = "Supplement" + 'B'; // s1 becomes SupplementB
        System.out.println(s1);

    }
    public static void comparingStrings(){
        System.out.println("comparing strings");
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "hello";
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);
        System.out.println(str1.equalsIgnoreCase(str3));
        System.out.println(str1.startsWith("H"));
        System.out.println(str1.endsWith("oo"));
    }
    public static void obtainingSubstrings(){
        System.out.println("obtaining substrings");
        String str = "Welcome to Java";
        System.out.println(str.substring(1, 5));
        System.out.println(str.substring(1));
        //Finding a Character or a Substring
        //in a String
        System.out.println("Finding a Character or a Substring");
        String str2 = "Welcome to Java to home";
        System.out.println(str2.indexOf('o'));
        System.out.println(str2.indexOf("to"));
        System.out.println(str2.indexOf("to", 5));
        System.out.println(str2.lastIndexOf('o'));
        System.out.println(str2.lastIndexOf("to"));
        System.out.println(str2.lastIndexOf("to", 5));
        String name="Ahmed naser";
        int index=name.indexOf(' ');
        System.out.println(index);
        System.out.println(name.substring(0, index));
        System.out.println(name.substring(index+1));
        System.out.println(name.substring(0, index) + " " + name.substring(index+1));


    }
    public static void  stringsToNumbers (){
        System.out.println("strings to numbers");
        //to convert a string to a number we use parseInt() and parseDouble() in Integer and Double classes
        int intValue = Integer.parseInt("123");
        double doubleValue = Double.parseDouble("12.12");
        //to convert a number to a string we use (+"") normal concatenation or String.valueOf()
        String s = 123 + "";
        System.out.println(s);
        String s2 = String.valueOf(123);
        System.out.println(s2);
    }
    public static void formatStrings(){
        System.out.println("format strings");
        boolean b = true;
        int i = 10;
        double d = 10.12;
        char c = 'A';
        String s = "Hello";
        System.out.format("%b %d %f %c %s", b, i, d, c, s);
        System.out.println();

    }
}
