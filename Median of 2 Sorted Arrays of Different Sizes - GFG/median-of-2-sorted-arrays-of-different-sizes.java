//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int nums1[], int nums2[]) 
    {
        // Your Code Here
        if (n > m) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = n;
            n = m;
            m = tmp;
        }
        int res[] = new int[n+m];
        int r=res.length;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < n) {
            res[k++] = nums1[i++];
        }
        while (j < m) {
            res[k++] = nums2[j++];
        }
        if(r%2!=0) {
            return (double)res[r/2];
        } else {
            return ((double)res[r/2]+(double)res[r/2-1])/2;
        }
    }
}