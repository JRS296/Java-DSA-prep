//To demonstrate Abstract classes

abstract class Parent {
    abstract void career(String name);
    abstract void partner(String name, int age);
}

class Son extends Parent{ //All child classes MUST override all abstract superclass methods marked abstract
    //2 abstract methods -> both to be overriden
    @Override
    void career(String name) {
        System.out.println("I'm going to be a "+name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I love "+name+". She is " + age);
    }
}

class Daughter extends Parent{ //All child classes MUST override all abstract superclass methods marked abstract
    //2 abstract methods -> both to be overriden
    @Override
    void career(String name) {
        System.out.println("I'm going to be a "+name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I love "+name+". He is " + age);
    }
}

class Main {
    public static void main(String[] args) {
        Son son = new Son();
        son.career("doctor");
        son.partner("Sara", 21);

        Daughter dhter = new Daughter();
        dhter.career("Engineer");
        dhter.partner("Kevin", 5);
    }
}