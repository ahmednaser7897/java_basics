package oop;

import java.io.*;
import java.util.*;


public class FileClass {
    public  void main(String[] args) {
       try {
           testfileClass();
           testAccessFile();
           testReadFile();
       }catch (Exception E){
           System.out.println(E.getMessage());
       }
    }
    void  testfileClass(){
        System.out.println("Test File Class");
        File file = new File("E:\\flutter_work\\java\\projects\\java_basics\\src\\oop\\test.text");
        System.out.println("Does it exist? " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read? " + file.canRead());
        System.out.println("Can it be written? " + file.canWrite());
        System.out.println("Is it a directory? " + file.isDirectory());
        System.out.println("Is it a file? " + file.isFile());
        System.out.println("Is it absolute? " + file.isAbsolute());
        System.out.println("Is it hidden? " + file.isHidden());
        System.out.println("Absolute path is " +
                file.getAbsolutePath());
        System.out.println("Last modified on " +
                new Date(file.lastModified()));
    }

    void  testAccessFile()throws Exception {
        System.out.println("Test Access File");
        File file = new File("E:\\flutter_work\\java\\projects\\java_basics\\src\\oop\\test2.text");
        if (file.exists()) {
            System.out.println("E:\\flutter_work\\java\\projects\\java_basics\\src\\oop\\test2.text");
            return;
        }

        // Create a file
        PrintWriter output = new PrintWriter(file);

        // Write formatted output to the file
        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);

        // Close the file
        output.close();
    }
    void  testReadFile()throws Exception{
        System.out.println("Test Read File");
        // Create a File instance
        File file = new File("E:\\flutter_work\\java\\projects\\java_basics\\src\\oop\\test2.text");

        // Create a Scanner for the file
        Scanner input = new Scanner(file);

        // Read data from a file
        while (input.hasNext()) {
            String firstName = input.next();
            String mi = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(
                    firstName + " " + mi + " " + lastName + " " + score);
        }

        // Close the file
        input.close();
    }
}
