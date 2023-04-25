//To demonstrate use of classes as a data-type, use of Constructors (default and parameterized), this keyword,

class Main {
    public static void main(String args[]) {
        Student ex1 = new Student(); //Creates new Object
        Student ex2 = ex1; //Creates reference for ex1
        Student ex3 = new Student(5,"Kailo", 85.6); 
        Student ex4 = new Student(ex3); //Call Student type parameterized constructor
    }
}

class Student { //student data-type - via class
    int rno;
    String name;
    float marks; //Attributes of datatype Student

    Student() {
        this (0, "default", 100.00); //Using this keyword to call constructor from another constructor;
    }

    Student (int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    Student (Student xyz) {
        this.rno = xyz.rno;
        this.name = xyz.name;
        this.marks = xyz.marks;
    }

    @Override
    protected void finalize() throws Throwable { //Garbage Collection associated functions
        System.out.println("Called when memory associated with class if freed up");
    }

    public void test() {
        System.out.println("Hello there");
    }
}