//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends






class Pair {
    int value;
    int ind;
    
    public Pair(int value, int ind) {
        this.value = value;
        this.ind = ind;
    }
}





class Solution {
    
    
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b) -> b.value - a.value);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0; 
        
        for(; i < k; i++) {
            que.add(new Pair(arr[i], i));
        }
        
        
        ans.add(que.peek().value);
        
        for( ; i < n; i++) {
            
            que.add(new Pair(arr[i], i));
            
            while(que.peek().ind <= i - k) {
                que.poll();
            }
            
            ans.add(que.peek().value);
        }
        
        return ans;
    }
    
    
}





