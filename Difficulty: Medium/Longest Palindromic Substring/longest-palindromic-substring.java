//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    
    String longestPalindrome(String S){

        
        int n = S.length();
        
        int[][] dp = new int[n][n];
        
        int maxLen = 1;
        
        int start = 0;
        
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for(int i = 0; i < n-1; i++) {
            if(S.charAt(i) == S.charAt(i+1)) {
                dp[i][i+1] = 1;
                
                if(maxLen < 2) {
                    maxLen = 2;
                    start = i;
                }
            }
        }
        
        
        for(int k = 3; k <= n; k++) {
            for(int i = 0; i <= n - k; i++) {
                int j = k + i - 1;
                if(dp[i+1][j-1] == 1 && S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = 1;
                    if(maxLen < k) {
                        maxLen = k;
                        start = i;
                    }
                }
            }
        }
        
        int lastInd = maxLen + start;
        
        return S.substring(start, lastInd);
        
    }
}






