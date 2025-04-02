//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
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
    
    public Pair(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Solution {
    
    
    public int orangesRotting(int[][] mat) {
        // Code here
        
        int numRows = mat.length;
        int numCols = mat[0].length;
        int minTime = Integer.MIN_VALUE;
        boolean isFreshOrange = false;
        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        
        int[][] disMax = new int[numRows][numCols];
        for (int rowInd = 0; rowInd < numRows; rowInd++) {
            for (int colInd = 0; colInd < numCols; colInd++) {
                if(mat[rowInd][colInd] == 2) {
                    que.add(new Pair(rowInd, colInd, 0));
                }
                
                if (mat[rowInd][colInd] == 1) {
                    disMax[rowInd][colInd] = Integer.MAX_VALUE;
                    isFreshOrange = true;
                } else {
                    disMax[rowInd][colInd] = -1;
                }
                
            }
        }
        
        if (!isFreshOrange) return 0;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0 };
        
        while(!que.isEmpty()) {
            Pair curPair = que.remove();
            
            for (int dirInd = 0; dirInd < 4; dirInd++) {
                
                int curX = curPair.x + dx[dirInd];
                int curY = curPair.y + dy[dirInd];
                int curDis = curPair.dis;
                
                if (areValidIndices(curX, curY, numRows, numCols) && mat[curX][curY] == 1 && 1 + curDis <= disMax[curX][curY]) {
                    disMax[curX][curY] = 1 + curDis;
                    mat[curX][curY] = 2;
                    que.add(new Pair(curX, curY, disMax[curX][curY]));
                }
                
            }
        }
        
        
        for (int rowInd = 0; rowInd < numRows; rowInd++) {
            for (int colInd = 0; colInd < numCols; colInd++) {
                if (disMax[rowInd][colInd] != -1) {
                    minTime = Math.max(minTime, disMax[rowInd][colInd]);
                }
                
            }
        }
        
        if (minTime == Integer.MAX_VALUE) {
            return -1;
        }
        
        return minTime;
        
        
    }
    
    public boolean areValidIndices(int x, int y, int numRows, int numCols) {
        return x >= 0 && y >= 0 && x < numRows && y < numCols;
    }
    
}







