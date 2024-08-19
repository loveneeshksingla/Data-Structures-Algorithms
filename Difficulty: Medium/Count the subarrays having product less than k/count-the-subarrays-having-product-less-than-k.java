//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            out.println(obj.countSubArrayProductLessThanK(a, n, k));
        }
        out.close();
	}
}


// } Driver Code Ends






//User function Template for Java


class Solution {
    
    public long countSubArrayProductLessThanK(long a[], int n, long k)
    {
        
        
        long count = 0;
        
        int startingInd = 0;
        
        long product = 1;
        
 
        
        for(int ind = 0; ind < n; ind++) {
            
            product *= a[ind];
                
            while(startingInd < ind && product >= k) {
                    product = product / a[startingInd++];
            }
                
            
            if(product < k) {
                count = count + ( ind - startingInd + 1) ;
            }
        }
        
        return count;
    }
}


