//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        
        int rows = arr.length;
        int cols = arr[0].length;
        
        int max = Integer.MIN_VALUE;
        int row = -1;
        
        for ( int rowInd = 0; rowInd < rows; rowInd++ ) {
            
            int firstInd = getOnesFirtsInd(arr[rowInd]);
            
            // System.out.println(firstInd + "m");
            
            if ( firstInd < cols ) {
                int length = cols - firstInd;
            
                if( max < length) {
                    max = length;
                    row = rowInd;
                }
            }
        }
        
        return row;
    }
    
    
    public int getOnesFirtsInd ( int[] arr) {
        
        int left = 0;
        int right = arr.length-1;
    
        
        while ( left <= right ) {
            
            int mid = (left + right) / 2;
            
            if (arr[mid] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}