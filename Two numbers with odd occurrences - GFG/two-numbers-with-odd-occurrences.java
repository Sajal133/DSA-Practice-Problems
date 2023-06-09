//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    public int[] twoOddNum(int Arr[], int N) {
        int xor = 0;
        
        // Calculate XOR of all array elements
        for (int i = 0; i < N; i++) {
            xor ^= Arr[i];
        }
        
        // Find the rightmost set bit in the XOR result
        int rightmostSetBit = xor & ~(xor-1);
        
        int x1 = 0;
        int x2 = 0;
        
        // Divide array elements into two groups based on the rightmost set bit
        for (int i = 0; i < N; i++) {
            if ((Arr[i] & rightmostSetBit) == 0) {
                x1 ^= Arr[i];
            } else {
                x2 ^= Arr[i];
            }
        }
        
        if(x1<x2)
        {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        return new int[]{x1,x2};
        
    }
}
