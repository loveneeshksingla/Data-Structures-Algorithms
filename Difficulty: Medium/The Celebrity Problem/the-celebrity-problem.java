//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        
        int n = mat.length;
        
        int upperInd = 0;
        int lowerInd = n-1;
        
        while(upperInd < lowerInd) {
            if (mat[upperInd][lowerInd] == 1) {
                upperInd++;
            } else {
                lowerInd--;
            }
        }
        
        for (int colInd = 0; colInd < n; colInd++) {
            if (mat[colInd][upperInd] != 1 || (mat[upperInd][colInd] ==1 && upperInd != colInd)) {
                return -1;
            }
        }
        
        
        return upperInd;
    }
}