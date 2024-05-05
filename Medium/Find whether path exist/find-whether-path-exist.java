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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends





class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int x = -1;
        int y = -1;
        boolean[][] vis = new boolean[n][n];
        
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        boolean res = solve(grid, x, y, n, vis);
        return res;
    }
    
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public boolean isFeasible(int x, int y, int n) {
        if(x < 0 || y < 0 || x >= n || y >= n) {
            return false;
        }
        
        return true;
    }
    
    
    public boolean solve(int[][] grid, int x, int y, int n, boolean[][] vis) {
        
        if(grid[x][y] == 2) {
            return true;
        }
        
        if(vis[x][y]) {
            return false;
        }
        
        vis[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            
            if(isFeasible(curX, curY, n) && grid[curX][curY] != 0) {
                boolean res = solve(grid, curX, curY, n, vis);
                if(res == true) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
}