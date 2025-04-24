//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int MinSquares(int n)
    {
        // Code here
        
        
        int[] dp = new int[n+1];
        
        if(n <= 3) return n;
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for(int num = 4; num <= n; num++) {
            
            dp[num] = num;
            
            for(int curNum = 1; curNum <= Math.sqrt(num); curNum++) {
                
                dp[num] = Math.min(dp[num], 1 + dp[num - (curNum*curNum)]);
            }
        }
        
        return dp[n];
        
    }
}



