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

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        while(l<r)
        {
            final int m = (l+r)/2;
            if(sumDivision(nums, m)<=threshold)
            {
                r=m;
            }
            else
            {
                l = m+1;
            }
        }
        return l;
    }
    private int sumDivision(int[] nums,int m)
    {
        int sum = 0;
        for(final int num:nums)
        {
            sum+=(num-1)/m+1;
        }
        return sum;
    }
}