package DataStructures;

import oop.inheritance.Circle;
import oop.inheritance.Geometric;
import oop.inheritance.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator {
  public static void main(String[] args) {
    Geometric g1 = new Rectangle(5, 5);
    Geometric g2 = new Circle(5);

    Geometric g =
      max(g1, g2, new GeometricObjectComparator());
    
    System.out.println("The area of the larger object is " + 
      g.getArea());
    Geometric[] list ={new Circle(1),new Rectangle(2,3),new Circle(3)};
    Arrays.sort(list, new GeometricObjectComparator());
    for (int i = 0; i < list.length; i++) {
      System.out.println(list[i].getArea());
    }
    // we can use lambda expression to make the code shorter
    Arrays.sort(list, (o1, o2) -> (int) (o1.getArea() - o2.getArea()));
    for (int i = 0; i < list.length; i++) {
      System.out.println(list[i].getArea());
    }
  }
  
  public static Geometric max(Geometric g1,
      Geometric g2, Comparator<Geometric> c) {
    if (c.compare(g1, g2) > 0)
      return g1;
    else
      return g2;
  }
}
// we create a comparator class to define how to compare two objects
// we implement the Comparator interface
class GeometricObjectComparator
        implements Comparator<Geometric> {
  public int compare(Geometric o1, Geometric o2) {
    double area1 = o1.getArea();
    double area2 = o2.getArea();

    if (area1 < area2)
      return -1;
    else if (area1 == area2)
      return 0;
    else
      return 1;
  }
}
