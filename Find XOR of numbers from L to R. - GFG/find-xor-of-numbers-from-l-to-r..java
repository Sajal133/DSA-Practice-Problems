//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int l;
            l = sc.nextInt();

            int r;
            r = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.findXOR(l, r);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int findXOR(int l, int r) {
        // Calculate XOR of all numbers from 1 to r
        int xorR = getXOR(r);
        
        // Calculate XOR of all numbers from 1 to l-1
        int xorLminus1 = getXOR(l - 1);
        
        // Calculate XOR of numbers from l to r
        int res = xorR ^ xorLminus1;
        
        return res;
    }
    
    private static int getXOR(int n) {
        // The XOR of consecutive numbers follows a pattern
        // The XOR of numbers from 1 to n, where n is even, is as follows:
        // 1 ^ 2 ^ 3 ^ ... ^ n = (n / 2) % 2 == 0 ? n : 1
        
        // The XOR of numbers from 1 to n, where n is odd, is as follows:
        // 1 ^ 2 ^ 3 ^ ... ^ n = (n / 2) % 2 == 0 ? n ^ 1 : 0
        
        int mod = n % 4;
        
        if (mod == 0) {
            return n;
        } else if (mod == 1) {
            return 1;
        } else if (mod == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }
}
