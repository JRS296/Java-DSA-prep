package Example_11;

// Java program to show working of user defined
// Generic functions

class Test3 {
	// A Generic method example
	static <T> void genericDisplay(T element)
	{
		System.out.println(element.getClass().getName()	+ " = " + element);
	}

	// Driver method
}

class Main {
    public static void main(String[] args)
	{
		// Calling generic method with Integer argument
		Test3.genericDisplay(11);

		// Calling generic method with String argument
		Test3.genericDisplay("GeeksForGeeks");

		// Calling generic method with double argument
		Test3.genericDisplay(1.0);
	}
}

