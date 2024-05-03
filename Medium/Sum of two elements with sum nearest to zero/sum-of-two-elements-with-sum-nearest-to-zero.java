//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)throws IOException
    {
        
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int[] arr = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(s[i]);

    		out.println (new Solution().closestToZero (arr, n));
        }
        out.close();
        
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public static int closestToZero (int arr[], int n)
    {
        // your code here
        
        Arrays.sort(arr);
        
        int i = 0;
        int j = n-1;
        
        long min = (long)Integer.MAX_VALUE;
        
        while(i < j) {
            long sum = (long)arr[i] + arr[j];
            
            if (Math.abs(sum) < Math.abs(min) || (Math.abs(sum) == Math.abs(min) && sum > min)) {
                min = sum;
            }
            
            if(sum < 0) {
                i++;
            }else {
                j--;
            }
        }
        
        return (int)min;
        
    }
}




