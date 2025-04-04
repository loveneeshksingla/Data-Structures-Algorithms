//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i) arr[i] = sc.nextInt();

            System.out.println(new Sol().search(n, arr));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Sol {
    public static int search(int n, int arr[]) {
        // your code here
        
        
        int ele = arr[0];
        
        for (int ind = 1; ind < n; ind++) {
            ele = ele ^ arr[ind];
        }
        
        return ele;
    }
}