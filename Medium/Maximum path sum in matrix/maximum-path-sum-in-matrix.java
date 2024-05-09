//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        
        int[][] ans = new int[N][N];
        
        
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int a, b;
                if(j - 1 < 0) {
                    a = 0;
                }else {
                    a = Matrix[i-1][j-1];
                }
                
                if(j + 1 >= N) {
                    b = 0;
                }else {
                    b = Matrix[i-1][j+1];
                }
                
                Matrix[i][j] = Matrix[i][j] + Math.max(Matrix[i-1][j], Math.max(a,b));
                
            }
        }
        
        int max = Integer.MIN_VALUE;
                    for(int i = 0; i  < N; i++) {
                if(max < Matrix[N-1][i]) {
                    max = Matrix[N-1][i];
                }
            }
        return max;
    
    }
}