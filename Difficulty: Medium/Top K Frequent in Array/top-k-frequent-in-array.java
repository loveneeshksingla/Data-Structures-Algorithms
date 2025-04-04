//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public ArrayList<Integer> topKFrequent(int[] arr, int k) {
        // Your code here
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int arrSize = arr.length;
        
        for (int ind = 0; ind < arrSize; ind++) {
            
            if (map.containsKey(arr[ind])) {
                map.put(arr[ind], map.get(arr[ind])+1);
            } else {
                map.put(arr[ind], 1);
            }
            
            
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
        new PriorityQueue<>((a, b) -> {
            int freqCompare = Integer.compare(b.getValue(), a.getValue()); // Sort by frequency (Descending)
            return (freqCompare != 0) ? freqCompare : Integer.compare(b.getKey(), a.getKey()); // If frequency is same, sort by key (Descending)
        });

        maxHeap.addAll(map.entrySet());
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int ind = 0; ind < k; ind++) {
            
            if(!maxHeap.isEmpty()) {
                int cur = maxHeap.remove().getKey();
                ans.add(cur);
            }
        }
        
        return ans;
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            ArrayList<Integer> res = new Solution().topKFrequent(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends