//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        
        int arr1Ind = 0;
        int arr2Ind = 0;
        
        long kthEle = 0;
        
        for(int curEleInd = 0; curEleInd < k; curEleInd++) {
            if(arr1Ind < n && arr2Ind < m && arr1[arr1Ind] < arr2[arr2Ind]) {
                kthEle = (long)arr1[arr1Ind++];
            }else if(arr1Ind < n && arr2Ind < m){
                kthEle = (long)arr2[arr2Ind++];
            }else if(arr1Ind < n) {
                kthEle = (long)arr1[arr1Ind++];
            }else if(arr2Ind < m) {
                kthEle = (long)arr2[arr2Ind++];
            }
        }
        
        return kthEle;
    }
}