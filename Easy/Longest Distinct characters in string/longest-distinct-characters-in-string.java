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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        
        
        int[] charIndex = new int[26];
        
        Arrays.fill(charIndex, -1);
        
        int strLen = S.length();
        
        int startInd = 0;
        int maxLen = Integer.MIN_VALUE;
        
        
        for(int ind = 0; ind < strLen; ind++) {
            
            int curCharInd = S.charAt(ind) - 'a';
            
            if(charIndex[curCharInd] == -1) {
                charIndex[curCharInd] = ind;
                maxLen = Math.max(maxLen,  ind - startInd + 1);
            }else {
                startInd = Math.max(startInd, charIndex[curCharInd] + 1);
                charIndex[curCharInd] = ind;
                maxLen = Math.max(maxLen,  ind - startInd + 1);
            }
        }
        
        return maxLen;
        
    }
}