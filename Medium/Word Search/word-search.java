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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
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






