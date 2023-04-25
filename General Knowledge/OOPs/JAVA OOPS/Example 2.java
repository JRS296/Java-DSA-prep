import Example1.Student.name; //Access to variables
import Example1.Student; //import entire classes
import Example1.test;//Can import functions as well


class Example2 {
    public static void main(String[] args) {
        Student x = new Student(13, "Heya", 15.0);
        System.out.println(x.name);
        test();
    }
}