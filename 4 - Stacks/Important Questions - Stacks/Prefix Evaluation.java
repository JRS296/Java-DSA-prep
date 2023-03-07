
// Java program to evaluate a prefix expression. Does not require brackets as the evaluation determines the order itself.

/*
Algorithm:
Step 1: Put a pointer P at the end of the end
Step 2: If character at P is an operand push it to Stack
Step 3: If the character at P is an operator pop two elements from the Stack. Operate on these elements 
according to the operator, and push the result back to the Stack
Step 4: Decrement P by 1 and go to Step 2 as long as there are characters left to be scanned in the expression.
Step 5: The Result is stored at the top of the Stack, return it
Step 6: End
 */
import java.util.*;

public class Main {
    static double evaluatePrefix(String exprsn) {
        Stack<Double> stack = new Stack<Double>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {

            if (exprsn.charAt(j) == ' ')
                continue;

            if (Character.isDigit(exprsn.charAt(j))) 
            {
                double num = 0, i = j;
                while (j < exprsn.length() && Character.isDigit(exprsn.charAt(j)))
                    j--;

                j++;

                for (int k = j; k <= i; k++) { //For more than one digit numbers
                    num = num * 10 + (double) (exprsn.charAt(k) - '0');
                }
                stack.push(num);
            } 
            else 
            {
                // Operator encountered -> Therefore, Pop two elements from Stack
                double o1 = (double) stack.peek();
                stack.pop();
                double o2 = (double) stack.peek();
                stack.pop();

                switch (exprsn.charAt(j)) {
                    case '+':
                        stack.push(o1 + o2);
                        break;
                    case '-':
                        stack.push(o1 - o2);
                        break;
                    case '*':
                        stack.push(o1 * o2);
                        break;
                    case '/':
                        stack.push(o1 / o2);
                        break;
                }
            }
        }

        return stack.peek();
    }

    // Driver code
    public static void main(String[] args) {
        String exprsn = "+ 9 * 12 6";
        System.out.print((int) evaluatePrefix(exprsn));
    }
}