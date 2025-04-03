//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends



class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        
        Stack<int[]> sta = new Stack<>();
        
        int arrSize = arr.length;
        
        int[] prevMove = new int[arrSize];
        int[] nextMove = new int[arrSize];
        int maxArea = arr[0];
        
        
        for (int ind = 0; ind < arrSize; ind++) {
            
            if (sta.isEmpty()) {
                prevMove[ind] = 0;
                sta.push(new int[] {arr[ind], ind});
            } else {
                
                while (!sta.isEmpty() && sta.peek()[0] >= arr[ind]) {
                    sta.pop();
                }
                
                if (sta.isEmpty()) {
                    prevMove[ind] = 0;
                } else {
                    int[] curEle = sta.peek();
                    prevMove[ind] = curEle[1] + 1;
                    
                }
                
                sta.push(new int[] {arr[ind], ind});
            }
        }
        
        while (!sta.isEmpty()) {
            sta.pop();
        }
        
        for (int ind = arrSize-1; ind >= 0; ind--) {
            
            if (sta.isEmpty()) {
                // System.out.println("---->" +ind + " " + (arrSize-1));
                nextMove[ind] = arrSize-1;
                sta.push(new int[] {arr[ind], ind});
            } else {
                
                while (!sta.isEmpty() && sta.peek()[0] >= arr[ind]) {
                    sta.pop();
                }
                
                if (sta.isEmpty()) {
                    nextMove[ind] = arrSize - 1;
                } else {
                    int[] curEle = sta.peek();
                    nextMove[ind] = curEle[1] - 1;
                    
                }
                
                sta.push(new int[] {arr[ind], ind});
            }
        }
        
        for (int ind = 0; ind < arrSize; ind++) {
            
            // System.out.println(prevMove[ind] + " " + nextMove[ind]);
            int diff = nextMove[ind] - prevMove[ind] + 1;
            
            int curArea = diff * arr[ind];
            
            maxArea = Math.max(maxArea, curArea);
        }
        
        return maxArea;
        
    }
}


















//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
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
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends