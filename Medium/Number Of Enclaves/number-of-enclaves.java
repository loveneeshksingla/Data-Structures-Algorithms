//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Pair {
    int count;
    boolean isTouchedBoundary;
    
    Pair(int count, boolean isTouchedBoundary) {
        this.count = count;
        this.isTouchedBoundary = false;
    }
    
}

class Solution {

    int numberOfEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for(int i = 1; i < n-1; i++) {
            for(int j = 1; j < m-1; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    vis[i][j] = true;
                    Pair cur = new Pair(1, false);
                    solve(grid, vis, i, j, cur);
                    if(!cur.isTouchedBoundary) {
                        ans += cur.count;
                    }
                }
            }
        }
        
        return ans;
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    boolean areIndexsFeasible(int x, int y, int tR, int tC) {
        if(x < 0 || y < 0 || x >= tR || y >= tC) {
            return false;
        }
        
        return true;
    }
    
    
    void solve(int[][] grid, boolean[][] vis, int x, int y, Pair cur) {
        
        
        int count = 0;
        int tR = grid.length;
        int tC = grid[0].length;
        
        for(int i = 0; i < 4; i++) {
            
            int curX = x + dx[i];
            int curY = y + dy[i];
            
            if(areIndexsFeasible(curX, curY, tR, tC) && !vis[curX][curY] && grid[curX][curY] == 1) {
                vis[curX][curY] = true;
                if(curX == 0 || curX == tR-1 || curY == 0 || curY == tC-1) {
                    cur.isTouchedBoundary = true;
                }
                cur.count++;
                solve(grid, vis, curX, curY, cur);
            }
        }
    }
}





