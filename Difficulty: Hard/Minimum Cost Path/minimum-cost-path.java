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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends







class Pair {
    int x;
    int y;
    int dis;
    
    public Pair(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}



class Solution
{
    
    private boolean areIndexsFeasible(int x, int y, int N) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int minimumCostPath(int[][] grid)
    {
        // Code here
        
        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        
        que.add(new Pair(0, 0, grid[0][0]));
        int N = grid.length;
        
        int[][] dis = new int[N][N];
  
        
        boolean[][] vis = new boolean[N][N];
        
        for(int rowInd = 0; rowInd < N; rowInd++) {
            for(int colInd = 0; colInd < N; colInd++) {
                dis[rowInd][colInd] = Integer.MAX_VALUE;
            }
        }
        
        while(!que.isEmpty()) {
            
            Pair curPair = que.remove();
            
            int curX = curPair.x;
            int curY = curPair.y;
            int curDis = curPair.dis;
            
        
            
            for(int ind = 0; ind < 4; ind++) {
                
                int tempX = curX + dx[ind];
                int tempY = curY + dy[ind];
                
                if(areIndexsFeasible(tempX, tempY, N)) {
                    
                    if(dis[tempX][tempY] > grid[tempX][tempY] + curDis) {
                        dis[tempX][tempY] = grid[tempX][tempY] + curDis;
                        que.add(new Pair(tempX, tempY, dis[tempX][tempY]));
                    }   
                }
            }
        }
        
        return dis[N-1][N-1];
    }
}









