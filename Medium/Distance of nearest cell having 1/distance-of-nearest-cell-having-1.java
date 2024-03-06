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


class Solution
{
    
    class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> que = new LinkedList<>();
        int[][] dis = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    dis[i][j] = 0;
                    que.add(new Pair(i, j));
                }else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!que.isEmpty()) {
            Pair cur  = que.remove();
            
            for(int i = 0; i < 4; i++) {
                int curX = cur.x + dx[i];
                int curY = cur.y + dy[i];
                
                if(areIndexsValid(grid, curX, curY) && dis[curX][curY] > dis[cur.x][cur.y] + (Math.abs(curX-cur.x) + Math.abs(curY-cur.y)) ) {
                    dis[curX][curY] = dis[cur.x][cur.y] + (Math.abs(curX-cur.x) + Math.abs(curY-cur.y));
                    que.add(new Pair(curX, curY));
                }
            }
        }
        
        
        return dis;
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    
    boolean areIndexsValid(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}





