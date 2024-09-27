//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim()); // input size of array
            int arr[] = new int[n];
            String inputLine2[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
            }

            Solution obj = new Solution();

            System.out.println(
                obj.circularSubarraySum(arr)); // print the circularSubarraySum
        }
    }
}

// } Driver Code Ends


class Solution {


    
        static int circularSubarraySum(int a[]) {
        
        // Your code here
        int n = a.length;
        int curMax = a[0];
        int max_so_far = a[0];
        int curMin = a[0];
        int min_so_far = a[0];
        int sum = a[0];
        
        for(int i = 1; i < n; i++) {
            
            curMax = Math.max(curMax+a[i], a[i]);
            max_so_far = Math.max(max_so_far, curMax);
            
            curMin = Math.min(curMin+a[i], a[i]);
            min_so_far = Math.min(min_so_far, curMin);
            
            // System.out.println(curMax + " " + max_so_far + " " + curMin + " " + min_so_far);
            sum += a[i];
        }
        
        
        if(min_so_far == sum) {
            return max_so_far;
        }
        
        return Math.max(max_so_far, sum-min_so_far);
    }
}
