//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] knightPos = new int[2];
            int[] targetPos = new int[2];
            for (int i = 0; i < 2; i++) {
                knightPos[i] = Integer.parseInt(S1[i]);
                targetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(knightPos, targetPos, n);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Pair {
    int x;
    int y;
    int dis;
    
    public Pair (int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        
        
        int[][] board = new int[n+1][n+1];
        
        
        
        for (int rowInd = 0; rowInd <= n; rowInd++) {
            for (int colInd = 0; colInd <= n; colInd++) {
                board[rowInd][colInd] = Integer.MAX_VALUE;
            }
        }
        
        
        
        int knightSX = knightPos[0];
        int knightSY = knightPos[1];
        
        int[] dx = {-1, -1, 1, 1, 2, 2, -2, -2};
        int[] dy = {-2, 2, -2, 2, 1, -1, -1, 1};
        
        Queue<Pair> que = new LinkedList<>();
        
        
        que.add(new Pair(knightSX, knightSY, 0));
        
        while (!que.isEmpty()) {
            
            Pair curPair = que.remove();
            
            int curX = curPair.x;
            int curY = curPair.y;
            int curDis = curPair.dis;
            
            for (int ind = 0; ind < 8; ind++) {
                int xDis = curX + dx[ind];
                int yDis = curY + dy[ind];
                
                if (validIndex(xDis, yDis, n) && curDis + 1 < board[xDis][yDis]) {
                    board[xDis][yDis] = 1 + curDis;
                    que.add(new Pair(xDis, yDis, board[xDis][yDis]));
                }
            }
        }
        
        if(board[targetPos[0]][targetPos[1]] == Integer.MAX_VALUE) return 0;
        return board[targetPos[0]][targetPos[1]];
        
    }
    
    public boolean validIndex(int x, int y, int n) {
        return x > 0 && y > 0 && x <= n && y <= n;
    }
}




