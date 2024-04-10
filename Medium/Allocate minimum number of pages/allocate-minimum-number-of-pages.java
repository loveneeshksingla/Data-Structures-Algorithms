//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends




//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
         if(N < M) return -1;
        int minPages = Integer.MIN_VALUE;
        int maxPages = 0;
        
        for(int i = 0; i < N; i++) {
            minPages = Math.max(minPages, A[i]);
            maxPages += A[i];
        }
        
        
        int ans = Integer.MAX_VALUE;
        
        while(minPages <= maxPages) {
            int curPagesFeasible = (minPages + maxPages) / 2;
            if(isCurPagesFeasible(A, curPagesFeasible, M)) {
                ans = curPagesFeasible;
                maxPages = curPagesFeasible - 1;
            }else {
                minPages = curPagesFeasible + 1;
            }
            
        }
        
        return minPages;
    }
    
    public static boolean isCurPagesFeasible(int[] A, int mid, int k) {
        int numPages = 0;
        int numStu = 1;
        
        for(int i =0; i < A.length; i++) {
            
            if(numPages + A[i] > mid) {
                numStu++;
                numPages = A[i];
            }else {
                numPages += A[i];
            }
        }
        
        return numStu <= k;
    }
    
    
    
};