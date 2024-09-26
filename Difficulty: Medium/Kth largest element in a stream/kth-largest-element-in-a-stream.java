//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int k = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            
            int[] arr = new int[n];
            
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            int[] ptr = ob.kthLargest(k,arr,n);
            for(int i=0; i<n; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends




class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
         int[] ans = new int[n];
 
        // Creating a min-heap using priority queue
        PriorityQueue<Integer> pq
            = new PriorityQueue<>((a, b) -> a - b);
 
        // Iterating through each element
        for (int i = 0; i < n; i++) {
 
            // If size of priority
            // queue is less than k
            if (pq.size() < k)
                pq.add(arr[i]);
            else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
 
            // If size is less than k
            if (pq.size() < k)
                ans[i] = -1;
            else
                ans[i] = pq.peek();
        }
 
        return ans;
    }
};