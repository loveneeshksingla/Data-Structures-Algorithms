//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        
        
        int minUnit = arr[0];
        int maxUnit = arr[0];
        
        for (int ind = 1; ind < arr.length; ind++) {
            if (minUnit < arr[ind]) {
                minUnit = arr[ind];
            }
            maxUnit += arr[ind];
        }
        
        while (minUnit <= maxUnit) {
            int midUnit = (minUnit + maxUnit) / 2;
            // System.out.println(minUnit + " " + maxUnit + " " + midUnit);
            boolean isPossible = isPossibleForUnits(arr, k, midUnit);
            
            if (isPossible) {
                maxUnit = midUnit - 1;
            } else {
                minUnit = midUnit + 1;
            }
            
            
            
        }
        
        return minUnit;
    }
    
    
    public boolean isPossibleForUnits(int[] arr, int k, int units) {
        
        int curUnits = 0;
        int requiredPainter = 1;
        
        for (int ind = 0; ind < arr.length; ind++) {
            curUnits += arr[ind];
            
            if (curUnits > units) {
                requiredPainter++;
                curUnits = arr[ind];
            }
        }
        
        if (requiredPainter <= k ) return true;
        return false;
    }
}
