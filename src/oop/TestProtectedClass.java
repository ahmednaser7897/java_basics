package oop;

public class TestProtectedClass {
    //default Visibility Modifier
    int x=1;
    //default Visibility Modifier
    void defaultTest() {
        System.out.println("default test method");
    }

    //public Visibility Modifier
    public int y=1;
    //public Visibility Modifier
    public void publicTest() {
        System.out.println("public test method");
    }

    //private Visibility Modifier
    private int z=1;
    //private Visibility Modifier
    private void privateTest() {
        System.out.println("private test method");
    }

    protected int w=1;
    protected void protectedTest() {
        System.out.println("protected test method");
    }
}
