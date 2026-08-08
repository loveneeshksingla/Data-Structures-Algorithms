



class Solution {
    public int longCommSubstr(String s1, String s2) {
        // code here
        
        
        int s1Len = s1.length();
        int s2Len = s2.length();
        
        int[][] dp = new int[s1Len+1][s2Len+1];
        
        for (int i = 0; i <= s1Len; i++) {
            dp[i][0] = 0;
        }
        
        for (int j = 0; j < s2Len; j++) {
            dp[0][j] = 0;
        }
        
        int max = 0;
        
        for (int row = 1; row <= s1Len; row++) {
            for (int col = 1; col <= s2Len; col++) {
                
                if (s1.charAt(row-1) == s2.charAt(col-1)) {
                    dp[row][col] = 1 + dp[row-1][col-1];
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        
        return max;
    }
}




