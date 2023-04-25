

class OuterClass {

    static class InnerClass { //Only nested classes can be static
        String name;

        InnerClass (String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        InnerClass a = new InnerClass("Name1"); //Does not depend on Outerclass objects, but internally can have its own object
        InnerClass b = new InnerClass("Name2");

        System.out.println(a.name);
        System.out.println(b.name);
    }

}

