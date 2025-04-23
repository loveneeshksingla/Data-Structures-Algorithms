//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countWays(int n) {
        // your code here
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int ind = 3; ind <= n; ind++) {
            dp[ind] = dp[ind-1] + dp[ind-2];
            // System.out.println(dp[ind]);
        }
        
        return dp[n];
    }
}
