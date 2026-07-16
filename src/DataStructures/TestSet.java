package DataStructures;

import oop.inheritance.*;

import java.util.*;

public class TestSet {
  public static void main(String[] args) {
//    testHashSet();
//    testLinkedHashSet();
    //testTreeSet();
    //testTreeSetWithComparator();
    setListPerformanceTest();
  }
  public static void testHashSet(){
    System.out.println("Test HashSet");
    // HashSet save the items in a different order of adding it
    // Create a hash set
    Set<String> set = new HashSet<>();

    // Add strings to the set
    set.add("London");
    set.add("Paris");
    set.add("New York");
    set.add("San Francisco");
    set.add("Beijing");
    //this will not add because it is duplicate
    set.add("New York");

    System.out.println(set);

    // Display the elements in the hash set
    for (String s: set) {
      System.out.print(s.toUpperCase() + " ");
    }

    // Process the elements using a forEach method
    System.out.println();
    set.forEach(e -> System.out.print(e.toLowerCase() + " "));
  }
  public static void testLinkedHashSet(){
    System.out.println("Test LinkedHashSet");
    // HashSet save the items in the same order of adding it
    // Create a hash set
    Set<String> set = new LinkedHashSet<>();

    // Add strings to the set
    set.add("London");
    set.add("Paris");
    set.add("New York");
    set.add("San Francisco");
    set.add("Beijing");
    set.add("New York");

    System.out.println(set);

    // Display the elements in the hash set
    for (String element: set)
      System.out.print(element.toLowerCase() + " ");
  }
  public static void testTreeSet(){
    System.out.println("Test TreeSet");
    // HashSet save the items a sorted order
    // even using the default compareTo method or a custom one or comparator
    // Create a hash set
    Set<String> set = new HashSet<>();

    // Add strings to the set
    set.add("London");
    set.add("Paris");
    set.add("New York");
    set.add("San Francisco");
    set.add("Beijing");
    set.add("New York");

    TreeSet<String> treeSet = new TreeSet<>(set);
    // will be sorted using the copareTo method
    // that is in the String class
    System.out.println("Sorted tree set: " + treeSet);

    // Use the methods in SortedSet interface
    System.out.println("first(): " + treeSet.first());
    System.out.println("last(): " + treeSet.last());
    System.out.println("headSet(\"New York\"): " +
            treeSet.headSet("New York"));
    System.out.println("tailSet(\"New York\"): " +
            treeSet.tailSet("New York"));

    // Use the methods in NavigableSet interface
    System.out.println("lower(\"P\"): " + treeSet.lower("P"));
    System.out.println("higher(\"P\"): " + treeSet.higher("P"));
    System.out.println("floor(\"P\"): " + treeSet.floor("P"));
    System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));
    System.out.println("pollFirst(): " + treeSet.pollFirst());
    System.out.println("pollLast(): " + treeSet.pollLast());
    System.out.println("New tree set: " + treeSet);
  }
  public static void testTreeSetWithComparator(){
    System.out.println("Test TreeSet With Comparator");
    //we can send the comparator as a lambda expression
    //Set<Geometric> set =
    //new TreeSet<>((o1, o2) -> (int) (o1.getArea() - o2.getArea()));
    // Create a tree set for geometric objects using a comparator
    Set<Geometric> set =
            new TreeSet<>(new GeometricObjectComparator());

    set.add(new Rectangle(2, 2));
    set.add(new Circle(40));
    set.add(new Circle(23));
    set.add(new Rectangle(4, 1));
    // we made the comparator over the area of the geometric objects
    //so Rectangle(4, 1) and Rectangle(2, 2) is the same for the set
    // so only one of them will be added
    //and the order will be based on the comparator

    System.out.println("A sorted set of geometric objects");
    for (Geometric element: set)
      System.out.println("area = " + element.getArea());
  }
  static final int N = 50000;
  public static void setListPerformanceTest(){
    System.out.println("Test Set List Performance");
    // Add numbers 0, 1, 2, ..., N - 1 to the array list
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < N; i++)
      list.add(i);
    Collections.shuffle(list); // Shuffle the array list

    // Create a hash set, and test its performance
    Collection<Integer> set1 = new HashSet<>(list);
    System.out.println("Member test time for hash set is " +
            getTestTime(set1) + " milliseconds");
    System.out.println("Remove element time for hash set is " +
            getRemoveTime(set1) + " milliseconds");

    // Create a linked hash set, and test its performance
    Collection<Integer> set2 = new LinkedHashSet<>(list);
    System.out.println("Member test time for linked hash set is " +
            getTestTime(set2) + " milliseconds");
    System.out.println("Remove element time for linked hash set is "
            + getRemoveTime(set2) + " milliseconds");

    // Create a tree set, and test its performance
    Collection<Integer> set3 = new TreeSet<>(list);
    System.out.println("Member test time for tree set is " +
            getTestTime(set3) + " milliseconds");
    System.out.println("Remove element time for tree set is " +
            getRemoveTime(set3) + " milliseconds");

    // Create an array list, and test its performance
    Collection<Integer> list1 = new ArrayList<>(list);
    System.out.println("Member test time for array list is " +
            getTestTime(list1) + " milliseconds");
    System.out.println("Remove element time for array list is " +
            getRemoveTime(list1) + " milliseconds");

    // Create a linked list, and test its performance
    Collection<Integer> list2 = new LinkedList<>(list);
    System.out.println("Member test time for linked list is " +
            getTestTime(list2) + " milliseconds");
    System.out.println("Remove element time for linked list is " +
            getRemoveTime(list2) + " milliseconds");
  }
  public static long getTestTime(Collection<Integer> c) {
    long startTime = System.currentTimeMillis();

    // Test if a number is in the collection
    for (int i = 0; i < N; i++)
      c.contains((int)(Math.random() * 2 * N));

    return System.currentTimeMillis() - startTime;
  }

  public static long getRemoveTime(Collection<Integer> c) {
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < N; i++)
      c.remove(i);

    return System.currentTimeMillis() - startTime;
  }
}
