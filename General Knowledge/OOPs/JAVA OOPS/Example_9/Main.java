import Example_9.Car;
import Example_9.Engine;

public class Main {
    public static void main(String[] args) {
        Car ex1 = new Car();
        ex1.start();
        ex1.acc();
        ex1.brake();
        ex1.stop();

        System.out.println(ex1.x);
        Engine ex2 = new Car();
        //System.out.println(ex2.x); -> This won't work as variable x is defined in Car, ex2 is of type Engine
    }
}
