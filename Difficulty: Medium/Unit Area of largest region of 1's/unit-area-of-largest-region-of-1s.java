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
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        boolean[][] vis = new boolean[numRows][numCols];
        int max = 0;
        
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    vis[i][j] = true;
                    int tempCount = dfs(grid, i, j,  vis);
                    max = Math.max(tempCount, max);
                }
            }
        }
        
        return max;
    }
    
    
    int[] dx = {-1, -1, -1, 1, 1 , 1, 0, 0};
    int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
    
    private boolean areIndexsFeasible(int x, int y, int numRows, int numCols) {
        return (x >= 0 && y >= 0 && x < numRows && y < numCols);
    }
    
    public int dfs(int[][] grid, int x, int y, boolean[][] vis) {
        
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        int count = 1;
        
        for(int  i  = 0; i < 8; i++) {
            
            int curX = x + dx[i];
            int curY = y + dy[i];
            
            if(areIndexsFeasible(curX, curY, numRows, numCols) && !vis[curX][curY] && grid[curX][curY] == 1) {
                vis[curX][curY] = true;
                count += dfs(grid, curX, curY, vis);
            }
            
        }
        
        
        return count;
        
        
    }
}