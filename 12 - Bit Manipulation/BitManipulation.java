import java.util.Scanner;

public class BitwiseOperators {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter first number: ");
		int num1 = input.nextInt();

		System.out.print("Enter second number: ");
		int num2 = input.nextInt();

		System.out.println("Bitwise AND: " + (num1 & num2));
		System.out.println("Bitwise OR: " + (num1 | num2));
		System.out.println("Bitwise XOR: " + (num1 ^ num2));
		System.out.println("Bitwise NOT: " + (~num1));
		System.out.println("Bitwise Left Shift: " + (num1 << 2));
		System.out.println("Bitwise Right Shift: " + (num1 >> 2));
		System.out.println("Bitwise Unsigned Right Shift: " + (num1 >>> 2));
        //Unlike unsigned Right Shift, there is no “<<<” operator in Java because the logical (<<) and arithmetic left-shift (<<<) operations are identical.

		input.close();
	}
}
