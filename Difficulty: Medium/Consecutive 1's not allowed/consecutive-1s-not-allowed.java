//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            int ans = new Solution().countStrings(n);

            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends






// User function Template for Java

class Solution {
    int countStrings(int n) {
        // code here
        int a = 1;
        int b = 1;
        
        for(int i = 1; i < n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        
        return (a + b);
        
    }
}