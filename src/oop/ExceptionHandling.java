package oop;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            Circle1 circle1 = new Circle1(10);
            Circle1 circle2 = new Circle1(-1);
            Circle1 circle3 = new Circle1(0);

        }catch (InvalidRadiusException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("this will always execute ");
        }
        System.out.println("instancesCount is "+Circle1.getInstancesCount());

    }
}

class Circle1{
    double radius;
    private static int instancesCount=0;
    Circle1(){
        this(1.0);
    }
    Circle1(double radius){
        setRadius(radius);
        instancesCount++;
    }
    void setRadius(double radius){
        if(radius<0){
            // we can throw the java exceptions
            //throw new IllegalArgumentException("radius cannot be negative");
            // or we can throw our custom exception
            throw new InvalidRadiusException(radius);
        }else{
            this.radius=radius;
        }

    }
    double getArea(){
        return radius*radius*Math.PI;
    }
    static int getInstancesCount(){
        return instancesCount;
    }

}

class InvalidRadiusException extends RuntimeException {
    public InvalidRadiusException(double radias) {
        super("radius cannot be negative "+radias);
    }
}
