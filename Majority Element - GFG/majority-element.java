//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int majorityElement(int num[], int size) {
        int candidate = num[0];
        int counter = 1;
        
        for (int i = 1; i < size; i++) {
            if (counter == 0) {
                candidate = num[i];
                counter = 1;
            } else {
                if (num[i] == candidate)
                    counter++;
                else
                    counter--;
            }
        }
        
        // Additional check to verify if candidate is the majority element
        int majorityCount = 0;
        for (int i = 0; i < size; i++) {
            if (num[i] == candidate)
                majorityCount++;
        }
        
        if (majorityCount > size / 2)
            return candidate;
        else
            return -1;
    }
}
