//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int len = str.length();
        int[][] dp = new int[len+1][len+1];
        
        for(int i = 0; i <= len; i++) {
            for(int j = 0; j <= len; j++) {
                dp[i][j] = -1;
            }
        }
        
        return pp(str, 0, str.length()-1, dp);
    }
    
    static int pp(String str, int i, int j, int[][] dp) {
        if(i >= j) {
            return 0;
        }
        
        if(dp[i+1][j+1] != -1) return dp[i+1][j+1];
        if(isPalindrome(str, i, j)) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            
            int c1, c2;
            if(dp[i+1][k+1] != -1) {
                c1 = dp[i+1][k+1];
            }else {
                c1 = pp(str, i, k, dp);
            }
            
            if(dp[k+2][j+1] != -1) {
                c2 = dp[k+2][j+1];
            }else {
                c2 = pp(str, k+1, j, dp);
            }
            
            int temp = c1 + c2 + 1;
            min = Math.min(temp, min);
            
        }
        return dp[i+1][j+1] = min;
    }
    
    
    static boolean isPalindrome(String str, int i, int j) {
        
        while(i <= j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            }else{
                return false;
            }
        }
        
        return true;
    }
}