//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            obj.print_divisors(n);
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static void print_divisors(int n) {
        // code here
        Set<Integer> res = new TreeSet<>();
        for(int i = 1;i*i<=n;i++)
        {
            if(n%i==0)
            {
                int t = n/i;
                res.add(i);
                res.add(t);
            }
        }
        for (int divisor : res) {
            System.out.print(divisor + " ");
        }
    }
}
