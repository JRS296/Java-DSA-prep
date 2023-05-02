//Singleton class - class with only 1 obkect i.e. Private Constructor

class Singleton { //Class which has only 1 object

    private Singleton () { //To prevent more than one instance being created - made private

    }

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance==null) {
            instance = new Singleton();
        }
        return instance;
    }

}

class Main {
    public static void main(String[] args) {
        Singleton obj1 = new Singleton.getInstance();
        Singleton obj2 = new Singleton.getInstance();
        Singleton obj3 = new Singleton.getInstance();

        //All 3 objects point to same object instance
    }
}