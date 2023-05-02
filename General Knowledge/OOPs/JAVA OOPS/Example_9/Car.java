package Example_9;
//Example of use of Implements keyword for interfaces

public class Car implements Engine, Brake{

    int x = 5;
    @Override
    public void start() {
        System.out.println("Able to start car");
    }

    @Override
    public void stop() {
        System.out.println("Able to stop car");
    }

    @Override
    public void acc() {
        System.out.println("Able to Accelerate car");
    }

    @Override
    public void brake() {
        System.out.println("Able to stop car using brake interface");
    }
}
