//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    static int size = 256;
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String s,String t)
    {
        int a =s.length();
        int b = t.length();
        
        if(a!=b)
            return false;
        
        boolean[] marked= new boolean[size];
        Arrays.fill(marked,Boolean.FALSE);
        
        int[] map = new int[size];
        Arrays.fill(map, -1);
        
        for(int i=0;i<b;i++){
            if(map[s.charAt(i)] == -1){
                if(marked[t.charAt(i)] == true)
                    return false;
                marked[t.charAt(i)] = true;
                map[s.charAt(i)]=t.charAt(i);
            }
            else if(map[s.charAt(i)]!=t.charAt(i))
                return false;
        }
        return true;
        
    }
}