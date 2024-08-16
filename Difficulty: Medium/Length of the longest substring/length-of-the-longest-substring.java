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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends








//User function Template for Java


class Solution{
    
    
    int longestUniqueSubsttr(String S){
        int res = 0;
        int i = 0;
        int strLen = S.length();
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        
        for(int j = 0; j < strLen; j++) {
            
            i = Math.max(i, lastIndex[S.charAt(j)] +1);
            
            res = Math.max(res, j - i +1);
            
            lastIndex[S.charAt(j)] = j;
        }
        
        
        return res;
        
        
    }
}