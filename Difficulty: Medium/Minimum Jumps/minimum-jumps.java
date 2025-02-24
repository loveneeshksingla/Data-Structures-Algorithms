//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution{
    static int minJumps(int[] arr){
        // your code here
        
        
        int arrLen = arr.length;
        int maxReach = arr[0];
        int steps = arr[0];
        int numJumps = 1;
        
        
        if(arrLen == 1) return 0;
        if(maxReach == 0) return -1;
        
        for(int ind = 1; ind < arrLen-1; ind++) {
            
            maxReach = Math.max(maxReach, ind + arr[ind]);
            
            steps--;
            
            if(steps <= 0) {
                
                if(maxReach <= ind) return -1;
                
                numJumps++;
                
                steps = maxReach - ind;
                
            }
        }
        
        
        return numJumps;
        
    }
}