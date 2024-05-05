//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends




//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        
        long max = 0;
        long min = arr[0];
        
        for(int i = 0;  i < n; i++) {
            max += arr[i];
            if(min < arr[i]) {
                min = arr[i];
            }
        }
        
        long mid = (min+max)/2;
        while(min <= max) {
            mid  = (min + max) / 2;
            
            if(isFeasible(arr, mid, k)) {
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        
        
        return min;
        
        
        
        
    }
    
    static boolean isFeasible(int[] arr, long mid, int k) {
        
        int p = 1;
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > mid) {
                sum = arr[i];
                p++;
            }
        }
        
        if(p <= k) {
            return true;
        }
        
        return false;
    }
}


