//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    
    static int knapsack(int W, int val[], int wt[]) {
        
        int totalItems = wt.length;
        int[][] dp = new int[totalItems+1][W+1];
        for(int i = 0; i <= totalItems; i++) {
            for(int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(W, val, wt, 0, dp);

        
    }
    
    public static int solve(int W, int[] val, int[] wt, int curInd, int[][] dp) {
        
        int totalItems = wt.length;
        
        if (curInd >= totalItems || W == 0) {
            return 0;
        }
        
        if(dp[curInd][W] != -1) return dp[curInd][W];
        if (wt[curInd] <= W) {
            return dp[curInd][W] = Math.max(val[curInd] + solve((W-wt[curInd]), val, wt, curInd+1, dp), solve(W, val, wt, curInd+1, dp));
        } else {
            return dp[curInd][W] = solve(W, val, wt, curInd+1, dp);
        }
        
        
    }
    
    
}
