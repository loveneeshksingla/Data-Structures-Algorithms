//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);
        
        int minDis = 1;
        int maxDis = stalls[n-1] - stalls[0];
        
        
        while(minDis <= maxDis) {
            int midDis = (minDis + maxDis) / 2;
            
            if(isDisFeasible(stalls, midDis, k)) {
                minDis = midDis + 1;
            }else {
                maxDis = midDis - 1;
            }
        }
        
        return maxDis;
        
    }
    
    
    private static boolean isDisFeasible(int[] stalls, int dis, int numCows) {
        
        int prevAssignedStallAt = stalls[0];
        numCows--;
        int n = stalls.length;
        
        for(int i = 1; i < n; i++) {
            
            int curDis = stalls[i] - prevAssignedStallAt;
            
            if(curDis >= dis) {
                prevAssignedStallAt = stalls[i];
                numCows--;
                if(numCows == 0) break;
            }
             
        }
        
        return numCows == 0;
    }
}




