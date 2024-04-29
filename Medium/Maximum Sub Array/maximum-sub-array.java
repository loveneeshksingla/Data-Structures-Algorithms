//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        
        
        int startingInd = -1;
        // int lastInd = -1;
        
        int startInd = 0;
        
        int maxSum = Integer.MIN_VALUE;
        int maxLen = Integer.MIN_VALUE;
        
        int curSum = 0;
        
        for(int ind = 0; ind < n; ind++) {
            
            if(a[ind] < 0) {
                startInd = ind+1;
                curSum = 0;
            }else {
                
                curSum += a[ind];
                
                if(maxSum < curSum) {
                    maxSum = curSum;
                    startingInd = startInd;
                    maxLen = ind - startInd + 1;
                }else if(maxSum == curSum && (ind - startInd + 1) > maxLen) {
                    maxLen = ind - startInd + 1;
                    startingInd = startInd;
                }
                
            }
            
            
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int lastInd = startingInd + maxLen;
        
        if(startingInd == -1) {
            ans.add(-1);
            return ans;
        }
        for(int ind = startingInd; ind < lastInd; ind++) {
            ans.add(a[ind]);
        }
        
        if(ans.size() == 0) {
            ans.add(-1);
        }
        
        return ans;
    }
}