//{ Driver Code Starts
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to check if we can reach the last index from the 0th index.
    public boolean canReach(int[] arr) {
        // code here
        
        // int numSteps = arr[0];
        
        for (int ind = 0; ind < arr.length; ind++) {
            
            int numSteps = arr[ind];
            
          
            
            int _ind = ind+1;
            
            int maxIndToReach = ind + arr[ind];
            int nextInd = _ind;
            // System.out.println(_ind + " " + "_ind");
            while (_ind <= (ind + numSteps) && _ind < arr.length) {
                int nextReach = _ind + arr[_ind];
                // System.out.println(nextReach + " " + "nextReach");
                if (maxIndToReach < nextReach) {
                    maxIndToReach = Math.max(maxIndToReach, nextReach);
                    nextInd = _ind;
                }
                _ind++;
            }
            // System.out.println(maxIndToReach + " " + "maxIndToReach");
            // System.out.println(nextInd + " " + "nextInd");
              if (maxIndToReach >= (arr.length-1)) {
                return true;
            }
            
            if (maxIndToReach == ind + arr[ind]) {
                return false;
            }
            
            ind = nextInd- 1;
        }
        
        return false;
        
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canReach(arr);

            if (ans) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends