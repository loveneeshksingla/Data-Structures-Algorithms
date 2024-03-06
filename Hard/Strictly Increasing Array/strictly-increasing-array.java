//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            long ans = ob.min_operations(nums);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int min_operations(int []arr)
    {
        // Code here
        int n = arr.length;
        int[] list = new int[n];
        
        for(int i = 0; i < n; i++) {
            list[i] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && (i - j) <= arr[i] - arr[j]) {
                    list[i] = Math.max(list[i], 1 + list[j]);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(list[i] > max) {
                max = list[i];
            }
        }
        
        return n - max;
    }
}