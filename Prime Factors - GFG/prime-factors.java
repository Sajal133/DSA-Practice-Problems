//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution {
    public int[] AllPrimeFactors(int n) {
        Set<Integer> f = new HashSet<>();

        // Handle the even factors of N
        while (n % 2 == 0) {
            f.add(2);
            n /= 2;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                f.add(i);
                n /= i;
            }
        }
 
        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            f.add(n);
            
        int[] primeFactors = new int[f.size()];
        int index = 0;
        for (int factor : f) {
            primeFactors[index++] = factor;
        }
        Arrays.sort(primeFactors);
        

        return primeFactors;
    }

}