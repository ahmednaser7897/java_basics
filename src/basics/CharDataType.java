package basics;

public class CharDataType {
    public static void main(String[] args) {
       charBasic();
       castingCharAndInt();
        comparisonTestingCharacters();
        characterClassMethods();
    }
    public static void charBasic(){
        //char is a 16-bit unsigned integer
        //char can be declared in two ways
        //1. Using ASCII by assigning a character or a number that is in the ASCII table
        //2. Using Unicode by using  a 4-digit hexadecimal number
        System.out.println("char declaration");
        char letter = 'A';// (ASCII)
        char numChar = '4';// (ASCII)
        char letter2 = '\u0041';// (Unicode)
        char numChar2 = '\u0034'; //(Unicode)
        System.out.println("letter = " + letter);
        System.out.println("numChar = " + numChar);
        System.out.println("letter2 = " + letter2);
        System.out.println("numChar2 = " + numChar2);
        // we can also use char to store a number
        char num = '5';
        System.out.println("num = " + num);
        // we can also use char to store a letter
        char letter3 = 'A';
        System.out.println("letter3 = " + letter3);
        // we can also use char to store a special character
        char specialChar = '@';
        System.out.println("specialChar = " + specialChar);
        // we can also use char to store a space
        char space = ' ';
        System.out.println("space = " + space);

        // we can increment and decrement char
        char b = 'B';
        b++;
        System.out.println("increment B = " + b);
        b--;
        System.out.println("decrement B = " + b);

    }
    public static void castingCharAndInt(){
        System.out.println("casting char and int");
        int i = 'a'; // Same as inti = (int)'a';
        char c = 97; // Same as char c = (char)97;
        System.out.println("i = " + i);
        System.out.println("c = " + c);
    }
    public static void comparisonTestingCharacters(){
        char ch = 'A';
        if (ch >= 'A' && ch <= 'Z')
            System.out.println(ch + " is an uppercase letter");
        else if (ch >= 'a' && ch <= 'z')
            System.out.println(ch + " is a lowercase letter");
        else if (ch >= '0' && ch <= '9')
            System.out.println(ch + " is a numeric character");
    }
    public static void characterClassMethods(){
        char ch = 'A';
        System.out.println("isUpperCase(" + ch + ") = " + Character.isUpperCase(ch));
        System.out.println("isLowerCase(" + ch + ") = " + Character.isLowerCase(ch));
        System.out.println("isLetterOrDigit(" + ch + ") = " + Character.isLetterOrDigit(ch));
        System.out.println("isDigit(" + ch + ") = " + Character.isDigit(ch));
        System.out.println("isLetter(" + ch + ") = " + Character.isDigit(ch));
        System.out.println("toLowerCase(" + ch + ") = " + Character.toLowerCase(ch));
        System.out.println("toUpperCase(" + ch + ") = " + Character.toUpperCase(ch));


    }


}
