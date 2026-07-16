package DataStructures;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
       testHashMap();
       testLinkedHashMap();
       testTreeMap();
       testTreeMap();

    }
    public static void testHashMap(){
        System.out.println("Test HashMap");
        // Create a HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");



    }
    public static void testLinkedHashMap(){
        System.out.println("Test LinkedHashMap");
        // Create a LinkedHashMap
        Map<String, Integer> linkedHashMap =
                new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        // Display the age for Lewis
        System.out.println("\nThe age for " + "Lewis is " +
                linkedHashMap.get("Lewis"));
        System.out.println("Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);

    }
    public static void testTreeMap(){
        System.out.println("Test TreeMap");
        // Create a TreeMap from the preceding HashMap
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Smith", 30);
        treeMap.put("Anderson", 31);
        treeMap.put("Lewis", 29);
        treeMap.put("Cook", 29);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);
        // Display each entry with name and age
        System.out.print("\nNames and ages are ");
        treeMap.forEach(
                (name, age) -> System.out.print(name + ": " + age + " "));
    }
    public static void countOccurrenceOfWords(){
        System.out.println("Test Counting Occurrence of Words");
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (String word : words) {
            String key = word.toLowerCase();
            if (!key.isEmpty()) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
        // Display key and value for each entry
        map.forEach((k, v) -> System.out.println(k + "\t" + v));

    }
}
