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
            int n = Integer.parseInt(br.readLine().trim());
            
            String input_line[] = br.readLine().trim().split("\\s+");
            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(input_line[i * n + j]); 
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.antiDiagonalPattern(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



 
//User function Template for Java

class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        // Code here
        
        int n = matrix.length;
        
        int[] ans = new int[n*n];
        int ansInd = 0;
        
        for(int i = 0; i < n; i++) {
            
            int row = 0;
            int col = i;
            
            while(row <= i) {
                
                ans[ansInd++] = matrix[row++][col--];
                
            }
        }
        
        for(int i = 1; i < n; i++) {
            
            int row = i;
            int col = n-1;
            
            while(row < n) {
                ans[ansInd++] = matrix[row++][col--];
            }
        }
        
        return ans;

    }
}







