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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        if(grid.length == 0 || grid == null)
        {
            return -1;
        }
        int a = grid.length;
        int b = grid[0].length;
        Queue<int[]> res = new LinkedList<>();
        int vis[][] = new int[a][b];
        int c = 0;
        for(int i = 0;i<a;i++)
        {
            for(int j = 0;j<b;j++)
            {
                if(grid[i][j]==2)
                {
                    res.offer(new int[]{i,j});
                }
                if(grid[i][j]!=0)
                {
                    c++;
                }
            }
        }
        if(c==0)
        {
            return 0;
        }
        int cM = 0;
        int tm = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        
        while(!res.isEmpty())
        {
            int size = res.size();
            tm +=size;
            for(int i=  0;i<size;i++)
            {
                int point[] = res.poll();
                for(int j = 0;j<4;j++)
                {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x<0 || y< 0 || x>=a || y>=b || grid[x][y]==0 || grid[x][y] == 2)
                    {
                        continue;
                    }
                    grid[x][y] = 2;
                    res.offer(new int[]{x,y});
                }
            }
            if(res.size()!=0)
            {
                cM++;
            }
            
        }
        return c==tm?cM:-1;
        
    }
}