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



class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        
        Queue<Pair> que = new LinkedList<>();
        
        int gridRowsLen = grid.length;
        int gridColsLen = grid[0].length;
        
        boolean[][] vis = new boolean[gridRowsLen][gridColsLen];
        int[][] dis = new int[gridRowsLen][gridColsLen];
        
        for(int rowInd = 0; rowInd < gridRowsLen; rowInd++) {
            for(int colInd = 0; colInd < gridColsLen; colInd++) {
                if(grid[rowInd][colInd] == 1) {
                    que.add(new Pair(rowInd, colInd));
                    dis[rowInd][colInd] = 0;
                    vis[rowInd][colInd] = true;
                }
            }
        }
        
        
        while(!que.isEmpty()) {
            
            Pair curPair = que.remove();
            
            int curX = curPair.x;
            int curY = curPair.y;
            
            for(int ind = 0; ind < 4; ind++) {
                
                int x = curX + dx[ind];
                int y = curY + dy[ind];
                
                if(areIndexsFaesible(x, y, gridRowsLen, gridColsLen) && grid[x][y] == 0 && !vis[x][y]) {
                    dis[x][y] = Math.abs(curX - x) + Math.abs(curY - y) + dis[curX][curY];
                    que.add(new Pair(x, y));
                    vis[x][y] = true;
                }
                
            }
        }
        
        return dis;
        
        
    }
    
    private boolean areIndexsFaesible(int x, int y, int totalRows, int totalCols) {
        return x >= 0 && y >= 0 && x < totalRows && y < totalCols;
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
}





