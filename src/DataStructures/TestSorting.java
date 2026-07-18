package DataStructures;

import java.util.Arrays;

public class TestSorting {
    static void main(String[] args) {
        testSelectionSorting(new int[]{5,7,34,3,7,89,12});
        testInsertionSorting(new int[]{5,7,34,3,7,89,12});
        testBubbleSorting(new int[]{5,7,34,3,7,89,12});
        testMergeSorting(new int[]{5,7,34,3,7,89,12});
         int[] list={5,7,34,3,7,89,12};
        testQuickSorting(list, 0, list.length - 1);
    }
    public static void testSelectionSorting(int[] list){
        System.out.println("Test Selection Sorting");
        //Time Complexity: O(n^2)
        System.out.println("List Before Sorting"+ Arrays.toString(list));
        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j <list.length ; j++) {
                if(list[i]>list[j]){
                    int temp=list[i];
                    list[i]=list[j];
                    list[j]=temp;
                }
            }
        }
        System.out.println("List After Sorting"+ Arrays.toString(list));
    }
    public static void testInsertionSorting(int[] list){
        System.out.println("Test Insertion Sorting");
        System.out.println("List Before Sorting"+ Arrays.toString(list));
        //Time Complexity: O(n^2)
        //start from item 2 (int i = 1) because item we assume 1 is already sorted
        for (int i = 1; i < list.length; i++) {
           /** insert list[i] into a sorted sublist list[0..i-1] so that
                 list[0..i] is sorted. */
           int currentElement = list[i];
           int j;
           for (j = i - 1; j >= 0 && list[j] > currentElement; j--) {
                 list[j + 1] = list[j];
               }

           // Insert the current element into list[j+1]
           list[j + 1] = currentElement;
        }
        System.out.println("List After Sorting"+ Arrays.toString(list));
    }
    public static void testBubbleSorting(int[] list){
        System.out.println("Test Bubble Sorting");
        //Time Complexity: O(n^2)
        System.out.println("List Before Sorting"+ Arrays.toString(list));
        boolean needSwap=true;
        for (int i = 1; i < list.length&& needSwap; i++) {
             needSwap=false;
            for (int j = 0; j <list.length -i ; j++) {
                if(list[j]>list[j+1]){
                    int temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                    needSwap=true;
                }
            }
        }
        System.out.println("List After Sorting"+ Arrays.toString(list));
    }
    public static void testMergeSorting(int[] list){
        System.out.println("Test Merge Sorting");
        //Time Complexity: O(nLogn) the fast sorting algorithm for now(faster than  selection, bubble and insertion sorting)
        System.out.println("List Before Sorting"+ Arrays.toString(list));
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            testMergeSorting(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            testMergeSorting(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
        System.out.println("List After Sorting"+ Arrays.toString(list));
    }
    /** Merge two sorted lists */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }
    public static void testQuickSorting(int[] list, int first, int last){
        System.out.println("Test Quick Sorting");
        //Time Complexity: O(n^2)

        if (last > first) {
            int pivotIndex = partition(list, first, last);
            testQuickSorting(list, first, pivotIndex - 1);
            testQuickSorting(list, pivotIndex + 1, last);
        }
        System.out.println("List After Sorting"+ Arrays.toString(list));
    }
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }

}
