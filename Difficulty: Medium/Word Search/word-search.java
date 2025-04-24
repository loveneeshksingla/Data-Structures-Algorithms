//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends






class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {

        int tR = board.length;
        int tC = board[0].length;
        
        
        for(int i = 0; i < tR; i++) {
            for(int j = 0; j < tC; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] vis = new boolean[tR][tC];
                    vis[i][j] = true;
                    boolean res = dfs(board, vis, i, j, word.substring(1));
                    if(res) return res;
                }
            }
        }
        
        return false;
        
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public boolean areIndexsFeasible(int x, int y, int tR, int tC) {
        if(x < 0 || y < 0 || x >= tR || y >= tC) {
            return false;
        }
        
        return true;
    }
    
    public boolean dfs(char[][] board, boolean[][] vis, int x, int y, String word) {
        if(word.length() == 0) {
            return true;
        }
        
       
        
        int tR = board.length;
        int tC = board[0].length;
        
        for(int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            
            if(areIndexsFeasible(curX, curY, tR, tC) && 
            !vis[curX][curY] && board[curX][curY] == word.charAt(0)){
                vis[x][y] = true;
                boolean res = dfs(board, vis, curX, curY, word.substring(1));
                if(res) return true;
                vis[x][y] = false;
            }
        }
        
        return false;
    }
}






