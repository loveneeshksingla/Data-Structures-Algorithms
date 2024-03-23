//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            long ans = ob.min_operations(nums);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int min_operations(int []nums)
    {
        
        
        int numsLen = nums.length;
        int[] sIC = new int[numsLen];
        
        for(int ind = 0; ind < numsLen; ind++) {
            sIC[ind] = 1;
        }
        
        sIC[0] = 1;
        
        int max = 1;
        
        for(int i =  1; i < numsLen; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] >= nums[j] && (i - j) <= (nums[i]- nums[j])) {
                    sIC[i] = Math.max(sIC[i], sIC[j]+1);
                    max = Math.max(max, sIC[i]);
                }
            }
            
        }
        
        
        return numsLen - max;
        
    }
}