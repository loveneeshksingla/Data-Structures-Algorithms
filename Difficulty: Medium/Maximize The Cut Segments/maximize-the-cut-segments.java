//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        // reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // reading total testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            // reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            int x = Integer.parseInt(read.readLine().trim());
            int y = Integer.parseInt(read.readLine().trim());
            int z = Integer.parseInt(read.readLine().trim());

            // calling method maximizeCuts() of class Solution()
            // and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends






//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.

    
    public int maximizeCuts(int n, int x, int y, int z) {
        // Your code here
        
        int[] dp = new int[n+1];
        for (int ind = 0; ind <= n; ind++) {
            dp[ind] = -1;
        }
        
        int res = solve(n, x, y, z, dp);
        
        if (res <= 0) return 0;
        return res;
    }
    
    
    public int solve(int n, int x, int y, int z, int[]  dp) {
        if (n <= 0) {
            return 0;
        }
        

        
        if (x > n && y > n && z > n) {
            return Integer.MIN_VALUE;
        }
        
        if (dp[n] != -1) return dp[n];
        
        int res1 = Integer.MIN_VALUE;
        int res2 = Integer.MIN_VALUE;
        int res3 = Integer.MIN_VALUE;
        
        if (x <= n)  {
            res1 = 1 + solve((n-x), x, y, z, dp);
        }
        if (y <= n)  {
            res2 = 1 + solve((n-y), x, y, z, dp);
        }
        if (z <= n)  {
            res3 = 1 + solve((n-z), x, y, z, dp);
        }
        
        return dp[n] = Math.max(res1, Math.max(res2, res3));
    }
    
}





