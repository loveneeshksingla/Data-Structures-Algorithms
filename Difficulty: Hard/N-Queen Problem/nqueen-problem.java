//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends






// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int[][] vis = new int[n][n];
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(i+1);
            vis[0][i] = 1;
            solve(ans, new ArrayList(cur), 1, i, vis, n);
        }
        return ans;
    }
    
    static boolean isValid(int x, int y, int n, int[][] grid) {
        
        int q = y-1;
        int w = y+1;
        int r = y;
        
        for(int i = x-1; i >= 0; i--) {
            
            if(q >= 0 && grid[i][q--] == 1) {
                return false;
            }
            
            if(w < n && grid[i][w++] == 1) {
                return false;
            }
            
            if(r >= 0 && grid[i][r] == 1) {
                return false;
            }
            
        }
        
        for(int j = y-1; j >= 0; j--) {
            if(grid[x][j] == 1) {
                return false;
            }
        }
        
        for(int j = y+1; j < n; j++) {
            if(grid[x][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    
    static void solve(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, int row, int col, int[][] vis, int n) {
        
        if(row >= n) {
            ans.add(cur);
            return;
        }
        
        
        for(int i = 0; i < n; i++) {
            int curRow = row;
            int curCol = i;
            if(isValid(curRow, curCol, n, vis)) {
                cur.add(curCol+1);
                vis[curRow][curCol] = 1;
                solve(ans, new ArrayList(cur), curRow+1, curCol, vis, n);
                cur.remove(cur.size()-1);
                vis[curRow][curCol] = 0;
            }
        }
        
    }
}





