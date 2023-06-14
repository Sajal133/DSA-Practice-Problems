//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int k) {
        int n = S.length();
        if (k == 0) {
            return S;
        }
        if (k == n) {
            return "0";
        }

        StringBuilder smallest = new StringBuilder();
        int len = n - k;  // Desired length of the resulting number

        for (char digit : S.toCharArray()) {
            while (k > 0 && smallest.length() > 0 && smallest.charAt(smallest.length() - 1) > digit) {
                smallest.deleteCharAt(smallest.length() - 1);
                k--;
            }
            smallest.append(digit);
        }

        // Handle the case where all remaining digits are in increasing order
        while (smallest.length() > len) {
            smallest.deleteCharAt(smallest.length() - 1);
        }

        // Remove leading zeros if any
        while (smallest.length() > 1 && smallest.charAt(0) == '0') {
            smallest.deleteCharAt(0);
        }

        return smallest.toString();
    }
}
