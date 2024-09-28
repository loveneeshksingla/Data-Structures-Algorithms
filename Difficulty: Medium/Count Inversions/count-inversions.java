//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            long arr[] = new long[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    // static long inversionCount(long arr[]) {
    //     // Your Code Here
    // }
    
    static long inversionCount(long arr[])
    {
        // Your Code Here
        long N = (long)arr.length;
        long res = solve(arr, 0, N-1);
        
        return res;
     }
    
    
    static long solve(long[] arr, long i, long j) {
        if(i < j) {
            long mid = ( i + j ) / 2;
            long count = 0;
            count += solve(arr, i, mid);
            count += solve(arr, mid+1, j);
            count += merge(arr, i, mid, j);
            return count;
        }
        
        return 0;
    }
    
    
    static long merge(long[] arr, long i, long mid, long j) {
        
        long x  = i;
        long y = mid+1;
        
        long size = j - i + 1;
        long count = 0;
        long[] ans = new long[(int)size];
        long z = 0;
        
        while(x <= mid && y <= j) {
            if(arr[(int) x] <= arr[(int) y]) {
                ans[(int) z++] = arr[(int) x++];
            }else {
                count = count + mid - x + 1;
                ans[(int) z++] = arr[(int) y++]; 
            }
        }
        
        while(x <= mid) {
            ans[(int) z++] = arr[(int) x++];
        }
        
        while(y <= j) {
            ans[(int) z++] = arr[(int) y++];
        }
        
        for (long h = 0; h < size; h++) {
            arr[(int) (i + h)] = ans[(int) h];
        }
        
        
        return count;
    }
}