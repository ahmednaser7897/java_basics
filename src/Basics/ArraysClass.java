package Basics;

import java.util.Arrays;

public class ArraysClass {
    public static void main(String[] args) {
       // arraysBasics();
       // arraysShuffling();
       // arraysShifting();
        // arraysLoops();
       // copyingArrays();
        //passingArraysToMethods();
        //variableLengthArguments();
        //testBinarySearch();
        testSelectionSort();
    }
    public  static  void arraysBasics(){
        System.out.println("Arrays Basics");
        //create array has 2 ways
        //this way is the old way and not recommended
        //1-Local variable 'oldArr' has C-style array type declaration
        //int oldArr[];

        //2-this way is the recommended way
        //this is called array declaration
        int[] arr ;
        //accessing array element will throw null pointer exception
        //System.out.println("arr is "+arr[0]);
        //this is called array initialization and must give it size
        arr = new int[5];
        // if no initialization is done then all elements will be 0 if type is int
        //0 for the numeric primitive data types,
        //'\u0000' for char types, and
        //false for boolean types.
        System.out.println("arr is "+arr[0]);

        //Declaring and Creating in One Step
        //datatype[] arrayRefVar = new  datatype[arraySize];
        double[] myList = new double[5];
        //we can give values to the array by the index
        for (int i=0;i<myList.length;i++){
            myList[i]=i;
        }
        for (int i=0;i<myList.length;i++){
            System.out.print("\tmyList["+i+"] is "+myList[i]);
        }
        System.out.println();
        // and we can give it values in the initialization
        //Declaring, creating, initializing in one step:
        //Shorthand Notation
        double[] myList1 = {1,2,3,4,5};
        for (int i=0;i<myList.length;i++){
            System.out.print("\tmyList2["+i+"] is "+myList[i]);
        }
        //Using the shorthand notation, you
        //have to declare, create, and initialize
        //the array all in one statement.
        //Splitting it would cause a syntax
        //error. For example, the following is
        //wrong:
        //double[] myList2;
        //myList2 = {1.9, 2.9, 3.4, 3.5};
    }
    public  static  void arraysShuffling(){
        System.out.println("Random shuffling");
        double[] myList={1,2,3,4,5,6};
        System.out.println("Main list");
        for (int i=0;i<myList.length;i++){
            System.out.print("\tmyList["+i+"] is "+myList[i]);
        }
        System.out.println();
        for (int i = 0; i < myList.length; i++) {
            int random=(int)(Math.random()*myList.length);
            double temp=myList[i];
            myList[i]=myList[random];
            myList[random]=temp;
        }
        System.out.println("shuffled list");
        for (int i=0;i<myList.length;i++){
            System.out.print("\tmyList["+i+"] is "+myList[i]);
        }
        System.out.println();



    }
    public  static  void arraysShifting(){
        System.out.println("Arrays Shifting");
        double[] myList={1,2,3,4,5};
        System.out.println("Main list");
        for (int i=0;i<myList.length;i++){
            System.out.print("\tmyList["+i+"] is "+myList[i]);
        }
        System.out.println();
        double temp=myList[0];
        for (int i = 1; i < myList.length; i++) {
            myList[i-1]=myList[i];
        }
        myList[myList.length-1]=temp;
        System.out.println("Shifted list");
        for (int i=0;i<myList.length;i++){
            System.out.print("\tmyList["+i+"] is "+myList[i]);
        }
        System.out.println();



    }
    public  static  void arraysLoops(){
        System.out.println("Arrays Loops");
        double[] myList={1,2,3,4,5};
        System.out.println("Print list by normal loop");
        for (int i=0;i<myList.length;i++){
            System.out.print("\tmyList["+i+"] is "+myList[i]);
        }
        System.out.println();
        System.out.println("Print list by enhanced for loop");
        for (double num:myList){
            System.out.print("\tmyList is "+num);
        }
        System.out.println();
    }
    public static  void copyingArrays(){
        System.out.println("Copying Loops");
        // primitive types coping by value
        System.out.println("primitive types coping");
        int a=1;
        int b=a;
        b=2;
        System.out.println("a is "+a);//a is 1
        System.out.println("b is "+b);//b is 2

        //reference types coping by reference
        System.out.println("reference types coping");
        int[] arr1={1,2,3};
        int[] arr2=arr1;
        arr2[0]=4;
        System.out.println("arr1 is "+arr1[0]);//arr1 is 4
        System.out.println("arr2 is "+arr2[0]);//arr2 is 4

        // we can copy list using loops
        System.out.println("coping using loops");
        int[] arr3={1,2,3};
        int[] arr4=new int[arr3.length];
        for (int i = 0; i < arr3.length; i++) {
            arr4[i] = arr3[i];
        }
        arr4[0]=4;
        System.out.println("arr3 is "+arr3[0]);//arr3 is 1
        System.out.println("arr4 is "+arr4[0]);//arr4 is 4

        // copy using arraycopy
        System.out.println("coping using arraycopy");
        int[] arr5={1,2,3};
        int[] arr6=new int[arr3.length];
        System.arraycopy(arr5, 0, arr6, 0, arr5.length);
        arr6[0]=4;
        System.out.println("arr3 is "+arr5[0]);//arr3 is 1
        System.out.println("arr4 is "+arr6[0]);//arr4 is 4

    }
    public static  void passingArraysToMethods(){
        System.out.println("Passing Arrays to Methods");
        // if we pass array to method it will be passed by reference
        // so when we change array in method it will change the original array
        int[] list = {1,2,3,4,5,6};
        printArray(list);
        System.out.println("list is "+list[0]);
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        array[0]=4;
        System.out.println();
    }
    public static  void variableLengthArguments (){
        System.out.println("Variable-Length Arguments");
        //instead of passing data as array we can pass data as variable length arguments
        //the normal way
        double[] list1 = {1,2,3,4,5};
        sum1(list1);
        sum1(new double[]{1,2,3,4,5});
        //the variable length arguments way by passing variable length arguments
        sum2(1,2,3,4,5);
        // or by passing array
        sum1(new double[]{1,2,3,4,5});
    }
    public static  void sum1(double[]arr){
        double sum=0;
        for (double num:arr){
            sum+=num;
        }
        System.out.println("sum is "+sum);
    }
    public static  void sum2(double...arr){
        double sum=0;
        for (double num:arr){
            sum+=num;
        }
        System.out.println("sum is "+sum);
    }
    public static  void testBinarySearch (){
        System.out.println("Binary Search");
        int[] list = {1,2,3,4,5,6,7,8,9,10};
        int x=8;
        int index1=  binarySearch(list,8);
        System.out.println("index1 is "+index1);
        int index2=  binarySearch(list,3);
        System.out.println("index2 is "+index2);
        int index3=  binarySearch(list,11);
        System.out.println("index3 is "+index3);
        //using java built in binary search
        int index4= Arrays.binarySearch(list,8);
        System.out.println("index4 is "+index4);

    }
    public static  int binarySearch (int[] list, int x){
        int low=0;
        int high=list.length-1;
        while (high>low){
            int mid=(low+high)/2;
            if(list[mid]==x){
                return mid;
            }else if(x>list[mid]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static  void testSelectionSort (){
        System.out.println("Selection Sort ");
        int[] list1 = {3,6,34,2,7,98,12,2,4,65,23};
        selectionSort(list1);
        printArray(list1);
        //using java built in sort
        int[] list2 = {3,6,34,2,7,98,12,2,4,65,23};
        Arrays.sort(list2);
        System.out.println(Arrays.toString(list2));
    }
    public static  void selectionSort (int[] list){
        for (int i = 0; i < list.length; i++) {
            int currentMin = list[i];
            for (int j=i+1;j<list.length;j++){
                if(currentMin>list[j]){
                    currentMin=list[j];
                    list[j]=list[i];
                    list[i]=currentMin;
                }
            }
        }
    }

}
