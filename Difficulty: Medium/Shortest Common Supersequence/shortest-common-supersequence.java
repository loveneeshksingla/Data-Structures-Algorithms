//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        sc.nextLine();
        while (t-- > 0) {
            // taking String X and Y
            String X = sc.nextLine();
            String Y = sc.nextLine();

            // calling function shortestCommonSupersequence()
            System.out.println(new Solution().shortestCommonSupersequence(X, Y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    
    
    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        
        int s1Size = s1.length();
        int s2Size = s2.length();
        
        int[][] dp = new int[s1Size][s2Size];
        
        for (int rowInd = 0; rowInd < s1Size; rowInd++) {
            for (int colInd = 0; colInd < s2Size; colInd++) {
                dp[rowInd][colInd] = -1;
            }
        }
        
        int commomSeqSize = commonSequence(s1, s2, (s1Size-1), (s2Size-1), dp);
        
        return (s1Size + s2Size) - commomSeqSize;
    }
    
    
    public static int commonSequence(String s1, String s2, int s1Ind, int s2Ind, int[][] dp) {
        
        if (s1Ind < 0 || s2Ind < 0) {
            return 0;
        }
        
        if (dp[s1Ind][s2Ind] != -1) return dp[s1Ind][s2Ind];
        
        if ( s1.charAt(s1Ind) == s2.charAt(s2Ind)) {
            return dp[s1Ind][s2Ind] = 1 + commonSequence(s1, s2, (s1Ind - 1), (s2Ind-1), dp);
        } else {
            return dp[s1Ind][s2Ind] = Math.max(commonSequence(s1, s2, s1Ind-1, s2Ind, dp), commonSequence(s1, s2, s1Ind, (s2Ind-1), dp));
        }
    
    }
    
    
    
}















