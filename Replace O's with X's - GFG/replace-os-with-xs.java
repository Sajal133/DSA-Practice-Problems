//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char mat[][])
    {
        // code here
        int vis[][] = new int[n][m];
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        
        for(int j = 0;j<m;j++)
        {
            if(vis[0][j]==0 && mat[0][j] == 'O')
            {
                dfs(0,j,mat,vis,dx,dy);
            }
            
            if(vis[n-1][j] == 0 && mat[n-1][j] == 'O')
            {
                dfs(n-1,j,mat,vis,dx,dy);
            }
        }
        for(int i = 0;i<n;i++)
        {
            if(vis[i][0]==0 && mat[i][0] == 'O')
            {
                dfs(i,0,mat,vis,dx,dy);
            }
            
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O')
            {
                dfs(i,m-1,mat,vis,dx,dy);
            }
        }
        
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(mat[i][j] == 'O' && vis[i][j] == 0)
                {
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
        
    }
    static void dfs(int row,int col,char mat[][],int vis[][],int dx[],int dy[])
    {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i = 0;i<4;i++)
        {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0 && 
            mat[nrow][ncol] == 'O')
            {
                dfs(nrow,ncol,mat,vis,dx,dy);
            }
        }
    }
}