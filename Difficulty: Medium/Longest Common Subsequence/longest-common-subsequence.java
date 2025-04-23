//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    static int lcs(String s1, String s2) {
        // code here
        
        
        int[][] dp = new int[s1.length()][s2.length()];
        
        for (int ind = 0; ind < s1.length(); ind++) {
            for (int colInd = 0; colInd < s2.length(); colInd++) {
                dp[ind][colInd] = -1;
            }
        }
        
        return solve(s1, s2, s1.length()-1, s2.length()-1, dp);
        
    }
    
    static int solve(String s1, String s2, int s1Ind, int s2Ind, int[][] dp) {
        
        if (s1Ind < 0 || s2Ind < 0) {
            return 0;
        }
        
        
        // if (s1Ind == 0 && s2Ind == 0) {
        //     return 0;
        // }
        
        if (dp[s1Ind][s2Ind] != -1) return dp[s1Ind][s2Ind];
        
        if (s1.charAt(s1Ind) == s2.charAt(s2Ind)) {
            return dp[s1Ind][s2Ind] = 1 + solve(s1, s2, (s1Ind-1), (s2Ind-1), dp);
        } else {
            return dp[s1Ind][s2Ind] = Math.max(solve(s1, s2, s1Ind-1, s2Ind, dp), solve(s1, s2, s1Ind, s2Ind-1, dp));
        }
        
    }
}