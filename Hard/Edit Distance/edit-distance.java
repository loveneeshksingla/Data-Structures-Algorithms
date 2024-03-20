//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    
    public int editDistance(String s, String t) {
        // Code here
        
        int sLen = s.length();
        int tLen = t.length();
        
        int[][] dp = new int[sLen][tLen];
        
        for(int i = 0; i < sLen; i++) {
            for(int j = 0; j < tLen; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(s, t, sLen-1, tLen-1, dp);
    }
    
    
    public int solve(String s, String t, int sInd, int tInd, int[][] dp) {
        
        if(sInd < 0 && tInd < 0) return 0;
        
        if(sInd < 0) return tInd + 1;
        
        if(tInd < 0) return sInd+1;
        
        if(dp[sInd][tInd] != -1) return dp[sInd][tInd];
        
        if(s.charAt(sInd) == t.charAt(tInd)) {
            return solve(s, t, sInd-1, tInd-1, dp);
        }else {
            int a = 1 + solve(s, t, sInd, tInd-1, dp);
            int b = 1 + solve(s, t, sInd-1, tInd, dp);
            int c = 1 + solve(s, t, sInd-1, tInd-1, dp);
            
            return dp[sInd][tInd] = Math.min(a, Math.min(b,c));
        }
        
        
    }
    
    
    
}