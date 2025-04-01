//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        
        
        int numsSize = nums.length;
        int[][] dp = new int[numsSize+1][target+1];
        for (int rowInd = 0; rowInd <= numsSize; rowInd++) {
            for (int colInd = 0; colInd <= target; colInd++) {
                dp[rowInd][colInd] = -1;
            }
        }
        int ans = solve(nums, target, numsSize, dp);

        return ans;

    }
    
    
    public int solve(int[] nums, int target, int ind, int[][] dp) {
        if (target == 0) {
            

            int curInd = ind-1;
            int numsZero = 0;
            
            while( curInd >= 0) {
                if (nums[curInd] == 0) {
                    numsZero++;
                }
                curInd--;
            }
            
            int numsSubArr = (int)Math.pow(2, numsZero);
            return dp[ind][target] = numsSubArr;
        }
        if (ind <= 0) {
            return dp[ind][target] = 0;
        }
  
        if (dp[ind][target] != -1) return dp[ind][target];
        
        if (nums[ind-1] <= target) {
            return dp[ind][target] = solve(nums, target-nums[ind-1], ind-1, dp) + solve(nums, target, ind-1, dp);
        } else {
            return dp[ind][target] = solve(nums, target, ind-1, dp);
        } 
    }
    
}


