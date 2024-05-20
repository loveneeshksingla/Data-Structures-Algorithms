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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends






//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        String reverseStr = "";
        for(int i = S.length()-1; i >= 0; i--) {
            reverseStr += S.charAt(i) + "";
        }
        int strLen = S.length();
        int[][] dp = new int[strLen+1][strLen+1];
        for(int i  = 0 ; i <= strLen; i++) {
            for(int j = 0; j <= strLen; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(S, reverseStr, strLen, strLen, dp);
    }
    
    public int lcs(String s1, String s2, int s1i, int s2i, int[][] dp) {
        
        if(s1i <= 0 || s2i <= 0) {
            return 0;
        }
        
        if(dp[s1i-1][s2i-1] != -1) return dp[s1i-1][s2i-1];
        if(s1.charAt(s1i-1) == s2.charAt(s2i-1)) {
            return dp[s1i-1][s2i-1] = 1 + lcs(s1, s2, s1i-1, s2i-1, dp);
        }else {
            return dp[s1i-1][s2i-1] = Math.max(lcs(s1, s2, s1i-1, s2i, dp), lcs(s1, s2, s1i, s2i-1, dp));
        }
        
    }
    
}