//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends






//User function Template for Java

class Solution{
    static String longestPalindrome(String S){
        // code here
        
        int maxLen = 1;
        int startInd = 0;
        int strLen = S.length();
        
        int[][] dp = new int[strLen][strLen];
        
        for(int i = 0; i < strLen; i++) {
            dp[i][i] = 1;
        }
        
        for(int i = 0; i < strLen-1; i++) {
            if(S.charAt(i) == S.charAt(i+1)) {
                dp[i][i+1] = 1;
                
                if(maxLen < 2) {
                    maxLen = 2;
                    startInd = i;
                }
            }
        }
        
        for(int k = 3; k <= strLen; k++) {
            
            for(int i = 0; i <= strLen - k; i++){
                int j = k + i - 1;
                if(S.charAt(i) == S.charAt(j) && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                    
                    if(maxLen < k) {
                        maxLen = k;
                        startInd = i;
                    }
                }
            }
        }
        
        String ans = S.substring(startInd, startInd+maxLen);
        
        return ans;
        
    }
}





