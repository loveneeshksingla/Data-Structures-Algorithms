//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // your code here
        
        int count = 1;
        int arrLen = arr.length;
        int curEle = arr[0];
        
        for ( int ind = 1; ind < arrLen; ind++) {
            
            if ( curEle == arr[ind]) {
                count++;
            } else {
                count = count - 1;
                if (count == 0) {
                    curEle = arr[ind];
                    count = 1;
                }
            }
            
        }
        
        int eleCount = 0;
        
        for (int ind = 0; ind < arrLen; ind++) {
            if (arr[ind] == curEle) {
                eleCount++;
            }
        }
        
        // System.out.println(eleCount + " " + curEle);
        if (eleCount > (arrLen/2)) {
            return curEle;
        }
        
        return -1;
        
    }
}