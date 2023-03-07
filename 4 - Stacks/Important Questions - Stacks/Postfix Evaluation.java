// Java program to evaluate value of a postfix, Does not require brackets as the evaluation determines the order itself.

/*
Algorithm:
Step 1: Put a pointer P at the start of the String
Step 2: If character at P is an operand push it to Stack
Step 3: If the character at P is an operator pop two elements from the Stack. Operate on these elements 
according to the operator, and push the result back to the Stack
Step 4: Increment P by 1 and go to Step 2 as long as there are characters left to be scanned in the expression.
Step 5: The Result is stored at the top of the Stack, return it
Step 6: End
 */
import java.util.Stack;

class Test1 {
    static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ')
                continue;

            else if (Character.isDigit(c)) {
                int n = 0;

                while (Character.isDigit(c)) // For more than one digit numbers
                {
                    n = n * 10 + (int) (c - '0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;

                stack.push(n);
            } else // Operator encountered -> Therefore, Pop two elements from Stack
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
    }
}