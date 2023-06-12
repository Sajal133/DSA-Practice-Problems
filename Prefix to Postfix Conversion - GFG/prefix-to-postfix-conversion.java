//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
           Stack<String> stack = new Stack<>();

        // Read the prefix expression from right to left
        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                // Operand, push it onto the stack
                stack.push(Character.toString(ch));
            } else {
                // Operator, pop two operands from the stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // Construct the postfix expression
                String postfix = operand1 + operand2 + ch;

                // Push the postfix expression onto the stack
                stack.push(postfix);
            }
        }

        // The final postfix expression is on top of the stack
        return stack.pop();
    }
}
