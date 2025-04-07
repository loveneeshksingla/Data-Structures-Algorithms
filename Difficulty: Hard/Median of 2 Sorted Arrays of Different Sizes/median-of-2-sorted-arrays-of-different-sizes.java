//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String arr1[] = br.readLine().split(" ");
            int[] a = new int[arr1.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);

            String arr2[] = br.readLine().split(" ");
            int[] b = new int[arr2.length];

            for (int i = 0; i < arr2.length; i++) b[i] = Integer.parseInt(arr2[i]);

            if (b.length == 1 && b[0] == 0) {
                b = new int[0];
            }
            double res = new Solution().medianOf2(a, b);

            if (res == (int)res)
                System.out.println((int)res);
            else
                System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public double medianOf2(int a[], int b[]) {
        // Your Code Here
        
        
        int aInd = 0;
        int bInd = 0;
        
        int aSize = a.length;
        int bSize = b.length;
        
        int midInd = ((aSize + bSize) / 2) - 1;
        // System.out.println(midInd + "midInd");
        int curInd = 0;
        double m1 = 0;
        double m2 = 0;
        
        while (aInd < aSize && bInd < bSize && curInd <= (midInd+1) ) {
            m1 = m2;
            
            if (a[aInd] < b[bInd]) {
                m2 = (double)a[aInd];
                aInd++;
            
            } else {
                m2 = (double)b[bInd];
                bInd++;
            }
            
            curInd++;
            
        }
        
        if (curInd <= (midInd+1)) {
            while (aInd < aSize && curInd <= (midInd+1)) {
                m1 = m2;
                m2 = a[aInd];
                curInd ++;
                aInd++;
            }
            
            while (bInd < bSize && curInd <= (midInd+1)) {
                m1 = m2;
                m2 = b[bInd];
                curInd++;
                bInd++;
            }
        }
        
        
        
        
        if ((aSize + bSize) % 2 == 0) {
            return (double)(m1 + m2) / 2;
        }
        else return (double)m2;
    }
}


