//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        for(int i = 0;i<V;i++)
        {
            res.add(new ArrayList<Integer>());
        }
        
        for(int i = 0;i<V;i++)
        {
            for(int j = 0;j<V;j++)
            {
                if(adj.get(i).get(j)==1 && i!=j)
                {
                    res.get(i).add(j);
                    res.get(j).add(i);
                }
            }
        }
        
        int vis[] = new int[V+1];
        int c = 0;
        for(int i=0;i<V;i++)
        {
            if(vis[i] == 0)
            {
                c++;
                dfs(i,res,vis);
            }
        }
        return c;
        
    }
    private static void dfs(int i,ArrayList<ArrayList<Integer>> res,int vis[])
    {
        vis[i] = 1;
        for(int j : res.get(i))
        {
            if(vis[j]==0)
            {
                dfs(j,res,vis);
            }
        }
    }
};