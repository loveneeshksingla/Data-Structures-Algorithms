//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    
    
    
    public int[][] searchWord(char[][] grid, String word) {
        // Code here
        
        
        int rowSize = grid.length;
        int colSize = grid[0].length;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        boolean[][] vis = new boolean[rowSize][colSize];
        
        for (int rowInd = 0; rowInd < rowSize; rowInd++) {
            for (int colInd = 0; colInd < colSize; colInd++) {
                if (grid[rowInd][colInd] == word.charAt(0)) {
                    for (int dirInd = 0; dirInd < 8; dirInd++) {
                        vis[rowInd][colInd] = true;
                        boolean res = solve(grid, rowInd, colInd, word.substring(1), dirInd);
                        if (res) {
                            ArrayList<Integer> curList = new ArrayList<>();
                            curList.add(rowInd);
                            curList.add(colInd);
                            ans.add(curList);
                            break;
                        }
                   }
                }
            }
        }
        
        
        int[][] finalAns = new int[ans.size()][2];
        
        for (int ind = 0; ind < ans.size(); ind++) {
            
            finalAns[ind][0] = ans.get(ind).get(0);
            finalAns[ind][1] = ans.get(ind).get(1);
        }
        
        
        return finalAns;
        
    }
    
    
    int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1};
    
    
    public boolean areIndicesValid(int x, int y, int rowSize, int colSize) {
        return x >= 0 && y >= 0 && x < rowSize && y < colSize;
    }
    
    public boolean solve(char[][] grid, int rInd, int cInd, String word, int ind) {
        
        if (word.length() == 0) return true;
        
        
        int curX = rInd + dx[ind];
        int curY = cInd + dy[ind];
        
        if (!areIndicesValid(curX, curY, grid.length, grid[0].length)) {
            return false;
        }
        
        if ( grid[curX][curY] != word.charAt(0)) {
            return false;
        }
            
        return solve(grid, curX, curY, word.substring(1), ind);
            
        
    }
    
    
    
    
    
}






