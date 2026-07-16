
package DataStructures.data_structures;

import java.util.ArrayList;

public class learn_stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MainList<Integer> basicStack = new <Integer>BasicStack(3);
        MainList<Integer> listStack = new <Integer>ListStack(3);
        testStack(basicStack);
        System.out.println("-----------------------------");
        testStack(listStack);

    }

    private static void testStack(MainList stack) {
        stack.printList();
        stack.push(10);
        stack.push(20);
        System.out.println("peek  " + stack.peek());
        System.out.println("pop  " + stack.pop());
        stack.push(30);
        stack.push(40);
        stack.printList();
    }

}

class BasicStack<T> implements MainList<T> {

    private final T[] myList;
    private int index;
    private final int size;

    BasicStack(int size) {
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
        System.out.println("stack  " + s);

    }

}

class ListStack<T> implements MainList<T> {

    private final ArrayList<T> myList;

    ListStack(int size) {

        myList = new ArrayList<>();

    }

    @Override
    public void push(T value) {
        myList.add(value);
    }

    @Override
    public T pop() {
        return myList.remove(getSize() - 1);
    }

    @Override
    public T peek() {
        return myList.get(getSize() - 1);
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
        System.out.println("stack  " + s);

    }

}
