//Inheritence

public class Box {
    double l;
    double h;
    double w;

    Box() {
        this.h = -1;
        this.l = -1;
        this.w = -1;
    }

    Box(double side) {
        this.h = side;
        this.l = side;
        this.w = side;
    }

    Box(double l, double h, double w) {
        this.h = h;
        this.l = l;
        this.w = w;
    }

    Box(Box old) {
        this.h = old.h;
        this.l = old.l;
        this.w = old.w;
    }

    public void info() {
        System.out.println("Running the Box class");
    }
}

class Boxweight extends Box { // Extended class (child class) to factor in weight along with dimensions
    double weight;

    public Boxweight() {
        this.weight = -1;
    }

    public Boxweight(double l, double h, double w, double weight) {
        super(l, h, weight); // Super can call any of the constructors from Box
        int temp = super.l; // Access superclass l
        this.weight = weight;
    }

    Boxweight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public Boxweight(Boxweight other) { // Same as Box b3 = new Boxweight(0,5,5,3);
        super(other); // Even though Boxweight type is being passed - super has access to Box within
                      // Boxweight i.e. line 26
        weight = other.weight;
    }
}

public class BoxPrice { // Multilevel Inheritence i.e. Box -> Boxweight -> Boxprice
    BoxPrice(double side, double weight, double cost) {
        super(side, weight); // Side from Box, weight from Boxweight
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(1, 2, 3);
        Boxweight box2 = new Boxweight();
        System.out.println(box2.weight + " " + box2.w); // box 2 has properties of both Box and BoxWeight class

        Box box3 = new Boxweight(0, 0, 0, 0); // Same as line 55
        BoxPrice bp = new BoxPrice(5, 15.0, 24.5); 
    }
}