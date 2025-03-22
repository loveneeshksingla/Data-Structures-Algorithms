//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends






//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int arr[], int sum){
        int N = arr.length;
        // code here
        int[][] dp = new int[N+1][sum+1];
        for(int i = 0; i < N+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                dp[i][j] = -1;
            }
        }
        
        int resp =  isSubsetSumExists(N, arr, sum, dp);
        if(resp == 1) return true;
        return false;
        
        
    }
    
    static int isSubsetSumExists(int index, int[] arr, int sum, int dp[][]) {
        if(sum == 0) {
            return 1;
        }
        
        if(index <= 0) {
            return 0;
        }
        
        if(dp[index][sum] != -1) return dp[index][sum];
        
        if(arr[index-1] <= sum) {
            int a1 = isSubsetSumExists(index- 1, arr, sum-arr[index-1], dp);
            int a2 = isSubsetSumExists(index- 1, arr, sum, dp);
            if(a1 != 0 || a2 != 0) 
            {
                return dp[index][sum]  = 1;
            }else {
                return dp[index][sum] = 0;
            }
        }else {
            return dp[index][sum] = isSubsetSumExists(index-1, arr, sum, dp);
        }
        
        
    }
    
    
    
    
    
}