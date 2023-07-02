//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Node {
    int first;
    int second;
    int third; 
    Node(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int a = grid.length;
        int b = grid[0].length;
        
        int res[][] = new int[a][b];
        int vis[][] = new int[a][b];
        
        Queue<Node> q = new LinkedList<>();
        
        
        
        for(int i = 0;i<a;i++)
        {
            for(int j = 0;j<b;j++)
            {
                if(grid[i][j]==1)
                {
                   q.add(new Node(i,j,0)); 
                   vis[i][j]=1;
                }
                else
                {
                    vis[i][j] = 0;
                }
            }
        }
        
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            int dist = q.peek().third;
            q.remove();
            res[row][col] = dist;
            for(int i = 0;i<4;i++)
            {
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                
                if(nrow>=0 && nrow<a && ncol>=0 && ncol<b && vis[nrow][ncol] == 0)
                {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow,ncol,dist+1));
                }
            }
        }
        return res;
    }
}