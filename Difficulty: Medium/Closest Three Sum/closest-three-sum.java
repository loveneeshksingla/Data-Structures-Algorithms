//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] array, int target) {
        // code here
        
        int arrSize = array.length;
        Arrays.sort(array);
        
        int closetSum = Integer.MAX_VALUE;
        for (int ind = 0; ind < arrSize-2; ind++) {
            
            int leftInd = ind+1;
            int rightInd = arrSize - 1;
            
            while (leftInd < rightInd) {
                
                int curSum = array[ind] + array[leftInd] + array[rightInd];
                
                if (curSum == target) {
                    return curSum;
                }
                
                int curDiff = Math.abs(target - curSum);
                
                int closeDiff = Math.abs(target - closetSum);
                
                if (curDiff < closeDiff) {
                    closetSum = curSum;
                }
                
                if (curDiff == closeDiff) {
                    closetSum = Math.max(closetSum, curSum);
                }
                
                if (curSum < target) {
                    leftInd++;
                } else {
                    rightInd--;
                }
                
                
                
            }
        }
        
        return closetSum;
        
    }
}





