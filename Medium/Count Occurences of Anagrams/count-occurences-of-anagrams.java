//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        
        
        HashMap<Character, Integer> patMap = new HashMap<>();
        HashMap<Character, Integer> txtMap = new HashMap<>();
        
        int patLen = pat.length();
        int txtLen = txt.length();
        
        int numOfOccurrences = 0;
        
        for(int ind = 0; ind < patLen; ind++) {
            patMap.put(pat.charAt(ind), patMap.getOrDefault(pat.charAt(ind), 0) + 1);
        }
        
        
        
        for(int ind = 0; ind < txtLen; ind++) {
            txtMap.put(txt.charAt(ind), txtMap.getOrDefault(txt.charAt(ind), 0) + 1);
            
            if(ind >= patLen-1) {
                
                if(txtMap.equals(patMap)) {
                    numOfOccurrences++;
                }
                
                int firstKeyInd = ind - patLen + 1;
                txtMap.put(txt.charAt(firstKeyInd), txtMap.get(txt.charAt(firstKeyInd)) - 1);
                if(txtMap.get(txt.charAt(firstKeyInd)) == 0) {
                    txtMap.remove(txt.charAt(firstKeyInd));
                }
            }
            
            
        }
        
        return numOfOccurrences;
    }
}








