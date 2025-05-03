//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            String[] S = br.readLine().trim().split(" ");
            int[] nums = new int[n+m];
            for(int i = 0; i < S.length; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution obj = new Solution();
            obj.sortLastMelements(nums, n, m);
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    
    public void sortLastMelements(int[] nums, int n, int m) {
        // Code here
        
        merge(nums, n, (n+m-1));
        
    }
    
    public void merge (int[] nums, int l, int r) {
        
        if (l >= r) return;
        
        int mid = (l + r) / 2;
        merge(nums, l, mid);
        merge(nums, mid+1, r);
        mergeSort(nums, l, mid, r);
        
        
    }
    
    
    public void mergeSort (int[] nums, int l, int m, int r) {
        
        
        int[] arr = new int[r-l+1];
        
        
        int arrInd = 0;
        int left = l;
        int right = m + 1;
        
        while (left <= m && right <= r) {
            
            if (nums[left] < nums[right]) {
                arr[arrInd] = nums[left];
                left++;
            } else {
                arr[arrInd] = nums[right];
                right++;
            }
            
            arrInd++;
        }
        
        while (left <= m) {
            arr[arrInd] = nums[left];
            left++;
            arrInd++;
        }
        
        while (right <= r) {
            arr[arrInd] = nums[right];
            right++;
            arrInd++;
        } 
        
        
        arrInd = 0;
        for (int i = 0; i < arr.length; i++) {
            nums[l] = arr[i];
            l++;
        }
    }
    
    
    
}










