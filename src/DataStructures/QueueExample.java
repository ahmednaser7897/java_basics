package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // Add elements
        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Charlie");

        System.out.println("Queue: " + queue);

        // View the front element
        System.out.println("Front: " + queue.peek());

        // Remove the front element
        System.out.println("Removed: " + queue.poll());

        System.out.println("Queue after poll: " + queue);

        // Check if empty
        System.out.println("Is empty? " + queue.isEmpty());

        // Number of elements
        System.out.println("Size: " + queue.size());
    }
}