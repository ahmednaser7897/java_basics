package DataStructures;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        // Push elements
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Orange");

        System.out.println("Stack: " + stack);

        // Peek (top element)
        System.out.println("Top: " + stack.peek());

        // Pop (remove top element)
        System.out.println("Removed: " + stack.pop());

        System.out.println("Stack after pop: " + stack);

        // Check if empty
        System.out.println("Is empty? " + stack.isEmpty());

        // Search for an element
        System.out.println("Position of Apple: " + stack.search("Apple"));
    }
}