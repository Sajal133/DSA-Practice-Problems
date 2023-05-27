//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
    
    // compute reverse of a number
    public static long rev(long n)
    {
        long rev_num = 0;
         while(n > 0) 
          { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
          } 
          return rev_num;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
        //testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int N;
		    
		    
            //input N
		    N=sc.nextInt();
		    int R=0;
		    
		    	    
            // reverse the given number n
		    R=(int)rev(N);
	
            //power of the number to it's reverse
		    long ans=(long)obj.power(N,R);
		    System.out.println(ans);
		    
		    
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    private static final int MOD = 1000000007;

    long power(long x, int n) {
        if (n == 0) {
            return 1L;
        }
        
        if (n < 0) {
            x = power(x, -n);  // Handle negative exponent
            n = -n;
        }
        
        return recursivePow(x, n);
    }
    
    private long recursivePow(long x, int n) {
        if (n == 0) {
            return 1L;
        }
        
        long res = recursivePow(x, n / 2) % MOD;  // Take modulo at each step
        
        if (n % 2 == 0) {
            return (res * res) % MOD;
        } else {
            return (((res * res) % MOD) * (x % MOD)) % MOD;
        }
    }
    
    public int findPower(int num, int reverse) {
        long powNum = power(num, reverse);
        return (int) (powNum % MOD);
    }
}
