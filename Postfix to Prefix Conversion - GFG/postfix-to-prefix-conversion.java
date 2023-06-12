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
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < post_exp.length(); i++) {
            char ch = post_exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                // Operand, push it onto the stack
                stack.push(Character.toString(ch));
            } else {
                // Operator, pop two operands from the stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // Construct the prefix expression
                String prefix = ch + operand2 + operand1;

                // Push the prefix expression onto the stack
                stack.push(prefix);
            }
        }

        // The final prefix expression is on top of the stack
        return stack.pop();
    }
}
