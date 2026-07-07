package Basics;

import java.util.Arrays;

public class MultidimensionalArrays {
    public static void main(String[] args) {
        //multidimensionalArraysBasics();
        //arraysShuffling();
        arraysShifting();
    }
    public  static  void multidimensionalArraysBasics(){
        System.out.println("Multidimensional Arrays Basics");
        //Declare/Create Two-dimensional Arrays
        // Declare array ref var
        //dataType[][] refVar;
        double[][] refVar;
        // Create array and assign its reference to variable
        //refVar = new dataType[10][10];
        refVar = new double[10][10];
        // Combine declaration and creation in one statement
        //dataType[][] refVar = new dataType[10][10];
        double[][] refVar2=new double[10][10];
        // Alternative syntax but not recommended
        //dataType refVar[][] = new dataType[10][10];
        double[][] refVar3=new double[3][3];
        refVar3[0][0]=1;
        for (int i = 0; i < refVar3.length; i++) {
            for (int j = 0; j < refVar3[i].length; j++) {
                refVar3[i][j]=(int)(Math.random()*100);
            }
        }
        printArray(refVar3);
        System.out.println();
        //Declaring, Creating, and Initializing Using
        //Shorthand Notations
        double[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        printArray(array);
    }
    public static void printArray(double[][] array) {
        for (double[] ints : array) {
            for (double anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
    public  static  void arraysShuffling(){
        System.out.println("Random shuffling");
        double[][] myList={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println("Main list");
        printArray(myList);
        System.out.println();
        for (int i = 0; i < myList.length; i++) {
            for (int j = 0; j < myList[i].length; j++) {
                int row=(int)(Math.random()*myList.length);
                int column=(int)(Math.random()*myList[i].length);
                double temp=myList[i][j];
                myList[i][j]=myList[row][column];
                myList[row][column]=temp;
            }
        }
        System.out.println("shuffled list");
        printArray(myList);
        System.out.println();
    }
    public  static  void arraysShifting(){
        System.out.println("Arrays Shifting");
        double[][] myList={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println("Main list");
        printArray(myList);
        System.out.println();
        //double temp=myList[0][0];
        for (int i = 0; i < myList.length; i++) {
            double temp=myList[i][0];
            for (int j = 1; j < myList[i].length; j++) {
                myList[i][j-1]= myList[i][j];
            }
            myList[i][myList[i].length-1]=temp;
        }
        System.out.println("Shifted list");
        printArray(myList);
        System.out.println();
    }
}
