//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int stallsLen = stalls.length;
        Arrays.sort(stalls);
        
        int minDis = 1;
        int maxDis = stalls[stallsLen-1] - stalls[0];
        // int ans = Integer.MIN_VALUE;
        
        while (minDis <= maxDis) {
            int midDis = (minDis + maxDis) / 2;
            // System.out
            boolean isFeasibleDis = findFeasibleDis(stalls, midDis, k);
            
            if (isFeasibleDis) {
                minDis = midDis + 1;
            } else {
                maxDis = midDis - 1;
                 
            }
        }
        
        return maxDis;
    }
    
    public static boolean findFeasibleDis (int[] stalls, int midDis, int k) {
        
        int assignedStallsToCowCount = 1;
        
        int prevPos = stalls[0];
        
        for (int ind = 1; ind < stalls.length; ind++) {
            int curDis = stalls[ind] - prevPos;
            if (curDis >= midDis) {
                assignedStallsToCowCount++;
                prevPos = stalls[ind];
                
                if (assignedStallsToCowCount == k) break;
            }
        }
        
        return  assignedStallsToCowCount == k;
        
    }
    
    
    
    
}




