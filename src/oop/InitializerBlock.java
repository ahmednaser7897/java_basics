package oop;

public class InitializerBlock {
    public  int id;
    InitializerBlock(){
        System.out.println("Default Constructor(id = " + id + ")");
        System.out.println("id = " + id);
    }
    InitializerBlock(int id){
        this.id = id;
        System.out.println("Value Constructor(id = " + id + ")");

    }
    //initializer code works before the constructor
    //Instance initializer block works every time the object is created
    {
        System.out.println("Instance Initializer Block (id = " + id + ")");
    }
    //Static initializer block works only once time (the first time the class is loaded)
    static {
        System.out.println("Static Initializer Block" );
        //System.out.println("Static Initializer Block(id = " + id + ")" );
    }
    public void printId() {
        System.out.println("id = " + id);
    }
    public static void main(String[] args) {
        InitializerBlock initializerBlock1 = new InitializerBlock();
        InitializerBlock initializerBlock2 = new InitializerBlock(3);

    }
}
