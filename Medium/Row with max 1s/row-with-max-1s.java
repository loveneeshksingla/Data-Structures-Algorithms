//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        
        
        int rowWithMaxOne = -1;
        
        int minIndexOfOne = Integer.MAX_VALUE;
        
        for(int rowInd = 0; rowInd < n; rowInd++) {
            
            int onesLowerInd = getOnesLowerInd(arr[rowInd]);
            
            if(onesLowerInd < m) {
                
                if(onesLowerInd < minIndexOfOne) {
                    rowWithMaxOne = rowInd;
                }
                minIndexOfOne = Math.min(onesLowerInd, minIndexOfOne);
                
            }
            
        }
        
        return rowWithMaxOne;
        
        
    }
    
    int getOnesLowerInd(int[] arr) {
        
        int arrLen = arr.length;
        
        int leftInd = 0;
        int rightInd = arrLen - 1;
        
        while(leftInd <= rightInd) {
            
            int midInd = (leftInd + rightInd) / 2;
            
            if(arr[midInd] == 1) {
                rightInd = midInd-1;
            }else {
                leftInd = midInd+1;
            }
        }
        
        return leftInd;
        
    }
    
}





