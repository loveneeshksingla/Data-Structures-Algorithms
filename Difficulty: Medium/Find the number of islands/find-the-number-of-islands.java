//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    
    
    public int countIslands(char[][] grid) {
        // Code here
        
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        boolean[][] vis = new boolean[numRows][numCols];
        
        int numIslands = 0;
        
        for (int rowInd = 0; rowInd < numRows; rowInd++) { 
            for (int colInd = 0; colInd < numCols; colInd++) {
                if (!vis[rowInd][colInd] && grid[rowInd][colInd] == 'L') {
                    numIslands++;
                    vis[rowInd][colInd] = true;
                    solve(grid, rowInd, colInd, vis);
                }
            }
        }
        
        return numIslands;
        
    }
    
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {0, -1, 1, -1, 1, -1, 0, 1};
    
    
    public boolean validIndices(int x, int y, int numRows, int numCols) {
        return x >= 0 && y >= 0 && x < numRows && y < numCols;
    }
    
    public void solve(char[][] grid, int rInd, int cInd, boolean[][] vis) {
        
        for(int ind = 0; ind < 8; ind++) {
            
            int curX = dx[ind] + rInd;
            int curY = dy[ind] + cInd;
            
            if (validIndices(curX, curY, grid.length, grid[0].length) && !vis[curX][curY] && grid[curX][curY] == 'L') {
                vis[curX][curY] = true;
                solve(grid, curX, curY, vis);
            }
        }
        
    }
}














