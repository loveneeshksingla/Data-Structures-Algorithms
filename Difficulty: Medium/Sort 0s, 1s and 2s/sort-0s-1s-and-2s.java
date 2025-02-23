//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        
        int arrLen = arr.length;
        int zeroInd = 0;
        int twoInd = arrLen-1;
        
        for ( int ind = 0; ind < arrLen; ind++) {
            if (arr[ind] == 0) {
                swap(zeroInd, ind, arr);
                zeroInd++;
            } else if(arr[ind] == 2 && twoInd >= ind) {
                swap(twoInd, ind, arr);
                twoInd--;
                ind--;
            }
        }
        
    }
    
    
    public void swap(int firstInd, int secInd, int[] arr) {
        int temp = arr[firstInd];
        arr[firstInd] = arr[secInd];
        arr[secInd] = temp;
    }
}




















//{ Driver Code Starts.
// } Driver Code Ends