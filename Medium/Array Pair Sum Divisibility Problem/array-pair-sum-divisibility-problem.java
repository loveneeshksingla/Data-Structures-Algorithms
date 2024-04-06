//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        

        HashMap<Integer, Integer> map = new HashMap<>();
        
        int numsLen = nums.length;
        
        if(numsLen% 2 != 0) return false;
        
        int numPairs = 0;
        
        for(int ind = 0; ind < numsLen; ind++) {
            
            int rem = nums[ind] % k;
            
            if(map.containsKey(k - rem) && map.get(k-rem) > 0) {
                numPairs++;
                map.put((k-rem), map.get(k-rem)-1);
                continue;
            }else if(rem == 0 && map.containsKey(0) && map.get(0) > 0){
                numPairs++;
                map.put(0, map.get(0)-1);
                continue;
            }
            
            map.put(rem, map.getOrDefault(rem, 0)+1);
            
        }
        
        if(numPairs == numsLen/2 ) return true;
        
        return false;
        
    }
}






