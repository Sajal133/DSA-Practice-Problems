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
            int n = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.countNodes(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countNodes(int i) {
        // code here
        int sum = 1;
        if(i==1)
        {
            return 1;
        }
        for(int a = 1;a<i;a++)
        {
            sum =(int) Math.pow(2,a);
        }
        return sum;
    }
}