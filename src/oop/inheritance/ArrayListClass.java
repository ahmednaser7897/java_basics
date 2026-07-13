package oop.inheritance;
import java.util.*;
public class ArrayListClass {
    public  void main(String[] args) {
        testArrayList();
        castArrayList();
    }
    public void testArrayList(){
        System.out.println("test ArrayList");
        ArrayList<String> cities = new ArrayList<String>();
        ArrayList<String> cities1 = new ArrayList<>();
        cities.add("Cairo");
        cities.addAll(Arrays.asList("Alexandria", "Aswan"));
        cities.add(1,"Mansoura");
        System.out.println(cities.toString());
        cities.set(0,"Paris");
        System.out.println(cities.toString());
        cities.remove(1);
        cities.remove("Aswan");
        System.out.println(cities.toString());
        cities.clear();
        System.out.println(cities.toString());
    }
    public void castArrayList(){
        System.out.println("cast ArrayList");
        String[] array = {"red", "green", "blue"};
        // to convert array to ArrayList
        ArrayList<String> list = new
                ArrayList<>(Arrays.asList(array));
        System.out.println(list.toString());
        // to convert ArrayList to array
        String[] array1 = new String[list.size()];
        list.toArray(array1);
        System.out.println(Arrays.toString(array1));
        //max and min in an Array List
        ArrayList<String> cities1 = new ArrayList<String>(Arrays.asList("Cairo","Mansoura", "Aswan"));
        System.out.println("max city is "+Collections.max(cities1));
        System.out.println("min city is "+Collections.min(cities1));
        Collections.shuffle(cities1);
        System.out.println("shuffled cites is "+cities1.toString());
    }
}
