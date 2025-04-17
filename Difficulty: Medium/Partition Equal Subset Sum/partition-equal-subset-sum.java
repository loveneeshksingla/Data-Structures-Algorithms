//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        
        int arrSize = arr.length;
        int totalSum = 0;
        
        for (int ind = 0; ind < arrSize; ind++) {
            totalSum += arr[ind];
        }
        
        if (totalSum % 2 != 0) return false;
        
        int requireSum = totalSum / 2;
        int[][] dp = new int[arrSize+1][requireSum+1];
        
        for (int rowInd = 0; rowInd <= arrSize; rowInd++) {
            for (int colInd = 0; colInd <= requireSum; colInd++) {
                dp[rowInd][colInd] = -1;
            }
        }
        
        int result =  solve(arr, totalSum/2, 0, dp);
        
        return result == 1;
    }
    
    
    static int  solve(int[] arr, int sum, int ind, int[][] dp) {
        if (sum == 0) {
            return dp[ind][sum] = 1;
        }
        
        if (ind >= arr.length) {
            return 0;
        }
        
        if (dp[ind][sum] != -1) return dp[ind][sum];
        if (arr[ind] <= sum) {
            int res1 = solve(arr, (sum - arr[ind]), ind+1, dp);
            int res2 = solve(arr, sum, ind+1, dp);
            
            if (res1 == 1 || res2 == 1) return dp[ind][sum] = 1;
            return dp[ind][sum] = 0;
        } else {
            return dp[ind][sum] = solve(arr, sum, ind+1, dp);
        }
    }
}






