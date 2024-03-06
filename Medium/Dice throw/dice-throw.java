//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfWays(M,N,X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long noOfWays(int M , int N , int X) {
        // code here
        
        long[][] dp = new long[X+1][N+1];
        for(int i = 0; i <= X; i++) {
            for(int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(X, N, M, dp);
    }
    
    
    
    
    static long solve(int sum, int numDice, int faceVal, long[][] dp) {
        
        if(numDice == 0 && sum == 0) return 1;
        
        if(numDice == 0 || sum == 0) return 0;
        
        
        if(dp[sum][numDice] != -1) return dp[sum][numDice];
        
        long result = 0;
        for(int i = 1; i <= faceVal; i++) {
            if(i <= sum) {
                result = result + (long)solve(sum - i, numDice-1, faceVal, dp);
            }
        }
        
        return dp[sum][numDice] = result;
        
    }
};