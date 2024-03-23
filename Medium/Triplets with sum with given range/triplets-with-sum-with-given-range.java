//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[] = new int[N];
            for (int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            String[] input = new String[2];
            input = read.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int R = Integer.parseInt(input[1]);

            Solution ob = new Solution();
            System.out.println(ob.countTriplets(Arr, N, L, R));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countTriplets(int Arr[], int N, int L, int R) {
        // code here
        
        Arrays.sort(Arr);
        
        int triplesWithSumLessThanNEquL = countTriples(Arr, N, L-1);
        int triplesWithSumLessThanNEquR = countTriples(Arr, N, R);
        
        return triplesWithSumLessThanNEquR - triplesWithSumLessThanNEquL;
    }
    
    
    static int countTriples(int[] arr, int N, int uR) {
        
        
        int count = 0;
        
        for(int ind = 0; ind < N-2; ind++) {
            int left = ind + 1;
            int right = N - 1;
            
            
            while(left < right) {
                int sum = arr[ind] + arr[left] + arr[right];
                
                if(sum <= uR) {
                    count += right - left;
                    left++;
                }else {
                    right--;
                }
            }
        }
        
        return count;
    }
}



