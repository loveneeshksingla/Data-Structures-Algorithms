//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int points[][] = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) points[i][j] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minPoints(points, m, n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
	public int minPoints(int points[][],int M,int N) 
	{ 
	    // Your code goes here
	    
	    
	    int[][] dp = new int[M][N];
	    
	    dp[M-1][N-1] = points[M-1][N-1] < 0 ? Math.abs(points[M-1][N-1]) + 1 : 1;
	    
	    for(int i = M-2; i >= 0; i--) {
	        dp[i][N-1] = Math.max(dp[i+1][N-1] - points[i][N-1] , 1);
	    }
	    
	    for(int i = N-2; i >= 0; i--) {
	        dp[M-1][i] = Math.max(dp[M-1][i+1] - points[M-1][i], 1);
	    }
	    
	    for(int i = M-2; i>= 0; i--) {
	        for(int j = N-2; j >= 0; j--) {
	            int min = Math.min(dp[i+1][j] , dp[i][j+1]);
	            dp[i][j] = Math.max(min - points[i][j], 1);
	        }
	    }
	    
	    return dp[0][0];
	} 
}