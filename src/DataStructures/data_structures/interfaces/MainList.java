package DataStructures.data_structures.interfaces;

public interface MainList<T> {

    public void push(T value);

    public T pop();

    public T peek();

    public int getSize();

    public boolean isEmpty();

    public boolean isFull();

    public void printList();

}
