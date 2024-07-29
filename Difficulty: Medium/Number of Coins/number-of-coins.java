//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends




class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    
	    
	    int[][] dp = new int[M+1][V+1];
	    
	    for(int i = 0; i <= M; i++) {
	        for(int j = 0; j <= V; j++) {
	            if(i == 0) {
	                dp[i][j] = Integer.MAX_VALUE-1;
	            }
	            if(j == 0) {
	                dp[i][j] = 0;
	            }
	        }
	    }
	    
	    for(int j = 1; j <= V; j++) {
	        if(j % coins[0] == 0) {
	            dp[1][j] = j / coins[0];
	        }else {
	            dp[1][j] = Integer.MAX_VALUE-1;
	        }
	    }
	    
	    for(int i = 2; i <= M; i++) {
	        for(int j = 1; j <= V; j++) {
	            if(j >= coins[i-1]) {
	                dp[i][j] = Math.min((1 + dp[i][j-coins[i-1]]), dp[i-1][j]);
	            }else {
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    
	    if(dp[M][V] == Integer.MAX_VALUE-1) return -1;
	    return dp[M][V];
	    
	} 
}






