package functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

class SortWordsInArray {

    public static void main(String[] args) {
        // System.out.print("Please, enter words separated by space: ");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 7 words separated by spaces:");

        String[] words = scanner.nextLine().split("\\s+");
        // String[] words = { "JavaScript", "C#", "C++", "Python", "Java", "dotnet", "C"
        // };
        Arrays.sort(words, (String w1, String w2) -> w1.length() > w2.length() ? 1 : -1);
        System.out.println(Arrays.toString(words));
        scanner.close();
    }
}