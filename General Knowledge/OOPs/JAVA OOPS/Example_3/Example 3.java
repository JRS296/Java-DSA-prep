//To demonstrate use of static keyword

class Human {
    int age;
    boolean married;
    static long population; //Use case of static - common to all objects within Human

    public Human(int age, boolean married) {
        this.age = age;
        this.married = married;
        population+=1; //If static is not used, 1 seperate instance of population will be created each time Human object is created
    }
}

class Main {
    public static void main(String[] args) {
        Human rahul = new Human(0, false);
        Human subramaniam = new Human(100, true);

        //Without static -> population = 1 for both initializations
        System.out.println(Human.population);
        //With Static - population remains seperated from instances. i.e. Common to all instances

        System.out.println(rahul.population); //Gives error as it needs to be accessed via static way
        System.out.println(Human.population); //Correct way to access class static variable
    }
}
