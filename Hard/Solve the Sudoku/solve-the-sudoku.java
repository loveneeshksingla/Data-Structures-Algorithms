//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends




//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                
                if(grid[i][j] == 0) {
                    
                    for(int k = 1; k <= 9; k++) {
                        
                        if(isKValid(grid, k, i, j)) {
                            grid[i][j] = k;
                            boolean res = SolveSudoku(grid);
                            if(res) {
                                return res;
                            }
                            grid[i][j] = 0;
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    static boolean isKValid(int[][] grid, int k, int i, int j) {
        
        for(int x = 0; x < 9; x++) {
            if(grid[i][x] == k) {
                return false;
            }
            
            if(x != i && grid[x][j] == k) {
                return false;
            }
        }
        
        int sx = i - i % 3;
        int sy = j - j%3;
        
        for(int x = sx; x < sx+3; x++) {
            for(int y = sy; y < sy+3; y++) {
                if(x != i || y != j) {
                    if(grid[x][y] == k) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j ++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}