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
            int res = obj.sumSubarrayMins(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int sumSubarrayMins(int N, int[] arr) {
        int mod = 1000000007;
        long result = 0;

        Stack<Integer> stack = new Stack<>();
        int[] prevSmaller = new int[N];
        int[] nextSmaller = new int[N];
        long[] count = new long[N];

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? N : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            count[i] = (i - prevSmaller[i]) * (nextSmaller[i] - i) % mod;
        }

        for (int i = 0; i < N; i++) {
            result = (result + (count[i] * arr[i]) % mod) % mod;
        }

        return (int) result;
    }
}
