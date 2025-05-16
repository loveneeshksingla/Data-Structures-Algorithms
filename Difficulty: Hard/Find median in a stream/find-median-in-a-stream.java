//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        

        
        
        ArrayList<Double> ans = new ArrayList<>();
        
        for (int ind = 0; ind < arr.length; ind++) {
            addNumber(arr[ind]);
            
            if (maxHeap.size() == minHeap.size()) {
                double median = (( maxHeap.peek() + minHeap.peek() ) / 2.0);
                ans.add(median);
            } else {
                ans.add((double)maxHeap.peek());
            }
            
        }
        
        return ans;
    }
    
    
    public void addNumber(int num) {
        
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    
}






