//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        int l = 0;
        int r = n-1;
        while (l < r) {
      int m = (l + r) / 2;
      if (m % 2 == 1)
        --m;
      if (arr[m] == arr[m + 1])
        l = m + 2;
      else
        r = m;
    }

    return arr[l];
    }
}