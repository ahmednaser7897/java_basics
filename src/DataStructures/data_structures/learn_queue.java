
package DataStructures.data_structures;
import java.util.ArrayList;

public class learn_queue {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MainList<Integer> basicQueue = new <Integer>BasicQueue(3);
        MainList<Integer> listQueue = new <Integer>ListQueue(3);
        testQueue(basicQueue);
        System.out.println("-----------------------------");
        testQueue(listQueue);

    }

    private static void testQueue(MainList queue) {
        queue.printList();
        queue.push(10);
        queue.push(20);
        System.out.println("peek  " + queue.peek());
        System.out.println("pop  " + queue.pop());
        queue.push(30);
        queue.push(40);
        queue.printList();
    }

}

class BasicQueue<T> implements MainList<T> {

    private final T[] myList;
    private int index;
    private final int size;

    BasicQueue(int size) {
        this.size = size;
        index = -1;
        // myList = new T[this.size];// ERORR
        myList = (T[]) new Object[this.size];

    }

    @Override
    public void push(T value) {
        myList[++index] = value;
    }

    @Override
    public T pop() {
        return myList[index--];
    }

    @Override
    public T peek() {
        return myList[index];
    }

    @Override
    public int getSize() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public boolean isFull() {
        return (size - 1) == index;
    }

    @Override
    public void printList() {
        System.out.println("is empty  " + isEmpty());
        System.out.println("is full  " + isFull());

        String s = "";
        for (T t : myList) {
            s += t + " ";
        }
        System.out.println("queue  " + s);

    }

}

class ListQueue<T> implements MainList<T> {

    private final ArrayList<T> myList;

    ListQueue(int size) {

        myList = new ArrayList<>();

    }

    @Override
    public void push(T value) {
        myList.add(value);
    }

    @Override
    public T pop() {
        return myList.remove(0);
    }

    @Override
    public T peek() {
        return myList.get(0);
    }

    @Override
    public int getSize() {
        return myList.size();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void printList() {
        System.out.println("is empty  " + isEmpty());
        System.out.println("is full  " + isFull());

        String s = "";
        for (T t : myList) {
            s += t + " ";
        }
        System.out.println("queue  " + s);

    }

}
