//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends




class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        
        int[] pMap = new int[256];
        int[] sMap = new int[256];
        
        int sLen = s.length();
        int pLen = p.length();
        
        for(int ind = 0; ind < pLen; ind++) {
            int curCharInd = p.charAt(ind) - 'a';
            pMap[curCharInd]++;
        }
        
        int curCharFoundCount = 0;
        
        int start = 0;
        int startInd = -1;
        int minLen = Integer.MAX_VALUE;
        
        for(int ind = 0; ind < sLen; ind++) {
            
            int curCharInd = s.charAt(ind) - 'a'; 
            
            sMap[curCharInd]++;
            
            if(sMap[curCharInd] <= pMap[curCharInd]) {
                curCharFoundCount++;
            }
            
            if(curCharFoundCount == pLen) {
                
                while( sMap[s.charAt(start)-'a'] > pMap[s.charAt(start)-'a']) {
                    if(sMap[s.charAt(start)-'a'] > pMap[s.charAt(start)-'a']) {
                        sMap[s.charAt(start)-'a']--;
                    }
                    start++;
                }
                
                int curLen = ind - start + 1;
                
                if(minLen > curLen) {
                    minLen = curLen;
                    startInd = start;
                }
            }
        }
        
        if(startInd == -1) return "-1";
        
        return s.substring(startInd, (startInd + minLen));
        
    }
}





