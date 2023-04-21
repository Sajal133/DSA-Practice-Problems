//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int n, int nums[]){
        // code here
        int i = -1;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i >= 0) {
            for (int j = n - 1; j > i; --j)
            {
               if (nums[j] > nums[i]) {
                   swap(nums, i, j);
                   break;
        }
        }
        }
        reverse(nums,i+1,n-1);
        List<Integer> res = new ArrayList<>();
        for(int j = 0;j<n;j++)
        {
            res.add(nums[j]);
        }
        return res;
    }
    public static void reverse(int nums[], int s, int e) {
        while (s < e) {
            swap(nums,s++,e--);
        }
    }
    public static void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }
}