//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int arrSize = arr.length;
        int max = Integer.MIN_VALUE;
        
        for(int ind = 0; ind < arrSize; ind++) {
            map.put(arr[ind], ind);
        }
        
        
        for (int ind = 0; ind < arrSize; ind++) {
            
            int key = arr[ind];
            int count = 1;
            if (!map.containsKey(key-1)) {
                key++;
                while(map.containsKey(key)) {
                    count++;
                    key++;
                }
            }
            
            max = Math.max(max, count);
            
        }
        
        return max;
    }
}


