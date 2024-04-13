//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int A[], int n) {
        // code here
        
        
        
        
        int[] leftMin = new int[N];
        int[] rightMax = new int[N];
        
        leftMin[0] = A[0];
        
        for(int i = 1; i < N; i++) {
            leftMin[i] = Math.min(leftMin[i-1], A[i]);
        }
        
        rightMax[N-1] = A[N-1];
        
        for(int i = N-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], A[i]);
        }
        
        
        int i = 0;
        int j = 0;
        
        int max = 0;
        

        
        while(i < N && j < N) {
            if(leftMin[i] <= rightMax[j]) {
                max = Math.max(max, j-i);
                j++;
            }else {
                i++;
            }
        }
        
        return max;
        
    }
}


