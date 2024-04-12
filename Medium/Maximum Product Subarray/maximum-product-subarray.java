//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends




class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        
        long pre = 1;
        long suf = 1;
        
 
        
        long max = Integer.MIN_VALUE;
        
       for(int i = 0; i < n; i++) {
            
            pre *= arr[i];
            suf *= arr[n-i-1];
            max = Math.max(max,Math.max(pre, suf));
            if(pre == 0) {
                pre = 1;
            }
            
            if(suf == 0) {
                suf = 1;
            }
            
           
 
            
            
        }
        
        return max;
        
    }
}