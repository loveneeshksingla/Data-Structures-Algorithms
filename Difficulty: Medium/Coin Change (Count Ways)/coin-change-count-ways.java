//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    
    public int count(int coins[], int sum) {
        // code here.
        
        
        int coinsLen = coins.length;
        int[][] dp = new int[coinsLen+1][sum+1];
        for (int rowInd = 0; rowInd <= coinsLen; rowInd++) {
            for (int colInd = 0; colInd <= sum; colInd++) {
                dp[rowInd][colInd] = -1;
            }
        }
        return solve(coins, sum, coinsLen, dp);
    }
    
    
    public int solve(int[] coins, int sum, int ind, int[][] dp) {
        
        if (sum == 0) {
            return dp[ind][sum] = 1;
        }
        
        if (ind <= 0) {
            return dp[ind][sum] = 0;
        }
        if(dp[ind][sum] != -1) return dp[ind][sum];
        if (coins[ind-1] <= sum) {
            return dp[ind][sum] = solve(coins, (sum-coins[ind-1]), ind, dp) + solve(coins, sum, ind-1, dp);
        } else {
            return dp[ind][sum] =solve(coins, sum, ind-1, dp);
        }
    }
}