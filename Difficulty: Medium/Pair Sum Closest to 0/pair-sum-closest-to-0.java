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
        
out.println("~");
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
        
        
        
        int leftInd = 0;
        int rightInd = n-1;
        
        int close = Integer.MAX_VALUE;
        
        
        
        while (leftInd < rightInd) {
            
            int curSum = arr[leftInd] + arr[rightInd];
            
            if (curSum == 0) {
                return curSum;
            }
            
            int curDiff = Math.abs(curSum - 0);
            
            int prevDiff = Math.abs(close - 0);
            
            if (curDiff < prevDiff) {
                close = curSum;
            } else if (curDiff == prevDiff) {
                close = Math.max(curSum, close);
            }
            
            if (curSum < 0) {
                leftInd++;
            } else {
                rightInd--;
            }
            
        }
        
        return close;
    }
}







