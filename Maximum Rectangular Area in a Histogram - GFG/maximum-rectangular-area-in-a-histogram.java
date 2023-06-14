//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution {
    public static long getMaxArea(long hist[], long n) {
        return getMaxArea(hist);
    }

    public static long getMaxArea(long[] heights) {
        int N = heights.length;
        long maxArea = 0;

        int[] stack = new int[N + 1]; // Stack to store indices
        int top = -1; // Index of the top element in the stack

        for (int i = 0; i <= N; i++) {
            long h = (i == N) ? 0 : heights[i];

            while (top >= 0 && h < heights[stack[top]]) {
                long height = heights[stack[top]];
                top--;
                int width = (top < 0) ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            top++;
            stack[top] = i;
        }

        return maxArea;
    }
}

