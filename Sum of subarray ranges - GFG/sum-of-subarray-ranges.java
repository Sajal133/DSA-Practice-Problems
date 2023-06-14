//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            long res = obj.subarrayRanges(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long subarrayRanges(int n, int[] nums) {
        // code here
        if(nums==null || nums.length<=1)
        {
            return 0L;
        }
        long sum = 0;;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i=0;i<=n;i++)
        {
            while(!stack.isEmpty() && (i==n || nums[stack.peekLast()]<nums[i]))
            {
                int curr = stack.removeLast();
                int left = stack.isEmpty()? -1:stack.peekLast();
                int right = i;
                sum+=(long)(curr - left)*(right-curr)*nums[curr];
            }
            stack.add(i);
        }
        stack.clear();
        for(int i=0;i<=n;i++)
        {
            while(!stack.isEmpty() &&(i==n || nums[stack.peekLast()]>nums[i]))
            {
                int currMin = stack.removeLast();
                int left = stack.isEmpty()? -1:stack.peekLast();
                int right = i;
                sum-=(long)(currMin - left)*(right - currMin)*nums[currMin];
            }
            stack.add(i);
        }
        return sum;
    }
}
    