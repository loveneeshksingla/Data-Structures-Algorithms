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
        int n = str.length();
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        int ans = solve(str, 0, str.length()-1, dp);
        return ans;
    }
    
    
    static int solve(String str, int left, int right, int[][] dp) {
        
        if(left == right) return 0;
        
        if(isPalindrome(str, left, right)) return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int k = left; k < right; k++) {
            
            int c1, c2;
            
            if(dp[left][k] != -1) {
                c1 = dp[left][k];
            }else {
                c1 = solve(str, left, k, dp);
            }
            
            if(dp[k+1][right] != -1) {
                c2 = dp[k+1][right];
            }else {
                c2 = solve(str, k+1, right, dp);
            }
            
            int res = 1 + c1 + c2;
            
            min = Math.min(min, res);
            
        }
        
    
        return dp[left][right] = min;
    }
    
    
    static boolean isPalindrome(String str, int left, int right) {
        
        while(left <= right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
        
    }
    
    
}






