//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    
	    int[] sum = new int[n];
	    sum[0] = arr[0];
	    int maxSum = arr[0];
	    
	    for(int curInd = 1; curInd < n; curInd++) {
	        for(int prevInd = curInd-1; prevInd >= 0; prevInd--) {
	            if(arr[curInd] > arr[prevInd]) {
	                sum[curInd] = Math.max(sum[curInd], arr[curInd] + sum[prevInd]);
	            }else {
	                sum[curInd] = Math.max(sum[curInd], arr[curInd]);
	            }
	            maxSum = Math.max(sum[curInd], maxSum);
	        }
	    }
	    
	    return maxSum;
	    
	}  
}