//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends




class Solution {
    int transitionPoint(int arr[], int n) {
        // code here
        
        
        int left = 0;
        int right = n-1;
        
        while(left <= right) {
            int mid = left+right;
            
            if(arr[mid] == 1) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        
        if(left >= n) return -1;
        return left;
    }
}