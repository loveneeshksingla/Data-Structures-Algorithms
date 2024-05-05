//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr1 = new int[n], arr2 = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().maximizeArray(arr1, arr2, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        // code here
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a);
        HashSet<Integer> map = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            pq.add(arr2[i]);
        }
        
        for(int i = 0; i < n; i++) {
            pq.add(arr1[i]);
        }
        
        while(map.size() != n && !pq.isEmpty()) {
            int curEle  = pq.remove();
            map.add(curEle);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(map.contains(arr2[i])) {
                ans.add(arr2[i]);
                map.remove(arr2[i]);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(map.contains(arr1[i])) {
                ans.add(arr1[i]);
                map.remove(arr1[i]);
            }
        }
        
        return ans;
    }
}




