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
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        
        
        if (pat.length() > txt.length()) return 0;
        
        HashMap<Character, Integer> txtMap = new HashMap<>();
        HashMap<Character, Integer> patMap = new HashMap<>();
        
        
        for (int ind = 0; ind < pat.length(); ind++) {
            patMap.put(pat.charAt(ind), patMap.getOrDefault(pat.charAt(ind), 0) + 1);
        }
        
        
        int count = 0;
        
        for (int ind = 0; ind < txt.length(); ind++) {
            
            
            txtMap.put(txt.charAt(ind), txtMap.getOrDefault(txt.charAt(ind), 0) + 1);
            
            
            
            if (ind >= pat.length()) {
                
                
                txtMap.put(txt.charAt(ind-pat.length()), txtMap.get(txt.charAt(ind-pat.length()))-1);
                
                if (txtMap.get(txt.charAt(ind-pat.length())) == 0) {
                    txtMap.remove(txt.charAt(ind-pat.length()));
                }
                
            
            }
            
            if (txtMap.equals(patMap)) {
                count++;
            }
            
        }
        
        
        return count;
    }
}