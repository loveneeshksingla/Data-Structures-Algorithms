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

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1};
    
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        
        int rowsLen = grid.length;
        int colsLen = grid[0].length;
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        
        for(int rowInd = 0; rowInd < rowsLen; rowInd++) {
            for(int colInd = 0; colInd < colsLen; colInd++) {
                if(grid[rowInd][colInd] == word.charAt(0)) {
                    for(int ind = 0; ind < 8; ind++) {
                        
                        int curX = rowInd + dx[ind];
                        int curY = colInd + dy[ind];
                        
                        boolean res = solve(grid, curX, curY, ind, word.substring(1));
                        
                        if(res) {
                            ArrayList<Integer> tempAns = new ArrayList<>();
                            tempAns.add(rowInd);
                            tempAns.add(colInd);
                            ans.add(tempAns);
                            break;
                        }
                        
                    }
                }
            }
        }
        
        int totalAns = ans.size();
        int[][] finalAns = new int[totalAns][2];
        
        int tInd = 0;
        
        for(ArrayList<Integer> list : ans) {
            
            int num1 = list.get(0);
            int num2 = list.get(1);
            
            int[] newArr = {num1, num2};
            
            finalAns[tInd++] = newArr;
            
        }
        
        return finalAns;
    }
    
    public boolean areIndexsFeasible(int x, int y, int tR, int tC) {
        return x >= 0 && y >= 0 && x < tR && y < tC;
    }
    
    public boolean solve(char[][] grid, int x, int y, int ind, String word) {
        
        if(word.length() == 0) {
            return true;
        }
        
        int rowsLen = grid.length;
        int colsLen = grid[0].length;
        
        if(!areIndexsFeasible(x, y, rowsLen, colsLen)) {
            return false;
        }
        
        if(grid[x][y] != word.charAt(0)) {
            return false;
        }
        
        return solve(grid, x+dx[ind], y+dy[ind], ind, word.substring(1));
        
    }
}




