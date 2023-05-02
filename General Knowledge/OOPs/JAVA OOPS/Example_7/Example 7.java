//Polymorphism Example

class Shapes {
    void area() {
        System.out.println("I am in Shapes");
    }
}

class Circle extends Shapes {
    @Override //Override only for mehtods where body is different (like in this case)
    void area() {
        System.out.println("pi*r*r");
    }

    double area(double r) { //Here parameters is different, so is return type. THerefore cannot be overriden in this context
        return 3.14*r*r;
    }
}

class Traingle extends Shapes {
    void area() {
        System.out.println("1/2*b*h");
    }
}

class Square extends Shapes {
    void area() {
        System.out.println("s*s");
    }
}

class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square sqr = new Square();

        Shapes sqr2 = new Square();
        Shapes circle2 = new Circle();
        

        shape.area();
        circle.area();
        sqr.area();
        sqr2.area(); //Will call square.area
        circle2.area(); //will call circle.area

        // Shapes circle3 = new Circle();
        // double ans = circle3.area(4.5); //Beacuse area here is within scope of Shapes (see line 48) Therefore, needs to be defned in Shapes class
        //i.e. Parent obj = new Child(); -> Method called depends on type of Child - Called up casting

        Circle circle4 = new Circle();
        double ans2 = circle4.area(4.5); //Here area is within scope of circle, which is defined
        circle4.area();
    }
}