// Java program to evaluate value of a postfix, may require brackets to specify order of evaluation

/* STEPS:
1. While there are still tokens to be read in,
   1.1 Get the next token.
   1.2 If the token is:
       1.2.1 A number: push it onto the value stack.
       1.2.2 A variable: get its value, and push onto the value stack.
       1.2.3 A left parenthesis: push it onto the operator stack.
       1.2.4 A right parenthesis:
         1 While the thing on top of the operator stack is not a 
           left parenthesis,
             1 Pop the operator from the operator stack.
             2 Pop the value stack twice, getting two operands.
             3 Apply the operator to the operands, in the correct order.
             4 Push the result onto the value stack.
         2 Pop the left parenthesis from the operator stack, and discard it.
       1.2.5 An operator (call it thisOp):
         1 While the operator stack is not empty, and the top thing on the
           operator stack has the same or greater precedence as thisOp,
           1 Pop the operator from the operator stack.
           2 Pop the value stack twice, getting two operands.
           3 Apply the operator to the operands, in the correct order.
           4 Push the result onto the value stack.
         2 Push thisOp onto the operator stack.
2. While the operator stack is not empty,
    1 Pop the operator from the operator stack.
    2 Pop the value stack twice, getting two operands.
    3 Apply the operator to the operands, in the correct order.
    4 Push the result onto the value stack.
3. At this point the operator stack should be empty, and the value
   stack should have only one value in it, which is the final result.
 */
import java.util.Stack;

public class EvaluateString {
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));

                i--; // Offset correction
            } else if (tokens[i] == '(') { // Current token is an opening brace, push it to 'ops'
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') { // Closing brace encountered, solve entire brace
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/') {
                // While top of 'ops' has same
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty()) // For remaining expression evaluation
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(
            char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static int applyOp(char op,
            int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(EvaluateString.evaluate("10 + 2 * 6"));
        System.out.println(EvaluateString.evaluate("100 * 2 + 12"));
        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 )"));
        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
    }
}

// Simpler Solution: (Leetcode Soln)
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>(); // to handle parenthesis
        int n = s.length();
        int sum = 0;
        int sign = 1; // if we have to do addition of negative number
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) { // if digit length>1
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // to move i pointer to previous position
                     // or you can use new pointer then we dont have to do it
                val = val * sign;
                sign = 1;
                sum += val;
            } else if (ch == '(') { // parenthesis handle
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                sum *= st.pop();
                sum += st.pop();
            } else if (ch == '-') {
                sign *= -1;
            }
        }
        return sum;
    }
}
