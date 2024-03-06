//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        
        int min = Integer.MIN_VALUE;
        int max = 0;
        
        for(int i = 0; i < N; i++) {
            max += arr[i];
            min = Math.max(min, arr[i]);
        }
        
        int ans = 0;
        
        while(min <= max) {
            int mid = (min + max)/2;
            if(isMidFeasible(arr, K, mid)) {
                ans = mid;
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }
        
        return ans;
    }
    
    static boolean isMidFeasible(int[] arr, int K, int curF) {
        
        int sum = 0;
        int numK = 1;
        
        for(int i = 0; i < arr.length; i++) {
            sum  += arr[i];
            
            if(sum > curF) {
                numK++;
                sum = arr[i];
            }
        }
        
        return numK <= K;
        
        
    }
};







