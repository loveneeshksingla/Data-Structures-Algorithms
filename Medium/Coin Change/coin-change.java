//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends




// User function Template for Java

class Solution {
    
    
    
    public long count(int coins[], int N, int sum) {
        // code here.
        
        
        long[][] dp = new long[N+1][sum+1];
        
        for(int i = 0; i <= N; i++) {
            for(int j =0; j<= sum; j++) {
                dp[i][j] = -1;
            }
        }
        return (long)getCount(coins, N, sum, dp);
        
        
    }
    
    
    public long getCount(int[] coins, int n, int sum, long[][] dp) {
        if(sum == 0) {
            return 1;
        }
        
        if(n <= 0) {
            return 0;
        }
        
        if(dp[n][sum] != -1) return dp[n][sum];
        
        if(coins[n-1] <= sum) {
            return dp[n][sum] = (long)(getCount(coins, n, sum-coins[n-1], dp) + getCount(coins, n-1, sum, dp));
        }else {
            return dp[n][sum] = (long)getCount(coins, n-1, sum, dp);
        }
    }
    
    
    
    
    
    
    
}