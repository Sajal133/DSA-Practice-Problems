//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here
        s = s + '.';
        String ans = "";
        String res="";
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i)!='.')
            {
                ans = ans + s.charAt(i);
            }
            else
            {
                if (!ans.isEmpty()) { 
                    res = ans +'.'+ res;
                    ans = "";
                }
            }
        }
        return res.substring(0, res.length() - 1);
    }
}