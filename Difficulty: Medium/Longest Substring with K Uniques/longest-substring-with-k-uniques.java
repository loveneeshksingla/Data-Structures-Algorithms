//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    
    public int longestkSubstr(String s, int k) {
        // code here
        
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = -1;
        int startInd = 0;
        
        for (int ind = 0; ind < s.length(); ind++) {
            
            map.put( s.charAt(ind), map.getOrDefault(s.charAt(ind), 0) + 1);
            
            if (map.size() > k) {
                
                int tempInd = startInd;
                char tempC = s.charAt(startInd);
                
while (map.size() > k) {
            char leftChar = s.charAt(startInd);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            startInd++;
        }
                
            }
            
            if (map.size() == k) {
                int len = ind - startInd + 1;
                ans = Math.max(ans, len);
            }
            
        }
        
        return ans;
        
        
        
    }
    
    
    
    
}