//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    
	    int[][] dp = new int[n+1][k+1];
	    for(int i = 0; i <= n; i++) {
	        for(int j = 0; j <= k; j++) {
	            dp[i][j] = -1;
	        }
	    }
	    
	    int ans = solve(n, k, dp);
	    return ans;
	}
	
	
	static int solve(int e, int f, int[][] dp) {
	    
	    
	    if(f <= 1 || e == 1) return f;
	    
	    int ans  = Integer.MAX_VALUE;
	    
	    if(dp[e][f] != -1) return dp[e][f];
	    
	    for(int i = 2; i <= f; i++) {
	         int res = 1 + Math.max(solve(e-1, i-1, dp), solve(e, f-i, dp));
	         ans = Math.min(res, ans);
	    }
	    
	    return dp[e][f] = ans;
	}
}


