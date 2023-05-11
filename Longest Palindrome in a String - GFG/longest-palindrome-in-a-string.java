//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
        // code here
        String longest = "";
        for(int i = 0;i<s.length();i++)
        {
            String tmp = "";
            tmp = check(s,i,i);
            if(tmp.length()>longest.length())
            {
                longest = tmp;
            }
            tmp = check(s,i,i+1);
            if(tmp.length()>longest.length())
            {
                longest = tmp;
            }
        }
        return longest;
    }
    private static String check(String ar,int cl,int cr)
    {
        while (cl >=0 && cr < ar.length() && ar.charAt(cl) == ar.charAt(cr)){
            cl --;
            cr ++;
        }
        return ar.substring(cl + 1, cr);
        
    }
}