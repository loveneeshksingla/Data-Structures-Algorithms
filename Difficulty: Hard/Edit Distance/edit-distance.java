

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