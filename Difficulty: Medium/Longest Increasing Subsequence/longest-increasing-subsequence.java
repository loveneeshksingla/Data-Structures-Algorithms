//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    
    static int lis(int arr[]) {
        // code here
        
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        for (int ind = 1; ind < arr.length; ind++) {
            
            int lastEle = list.get(list.size()-1);
            // System.out.println(lastEle + "lastEle");
            if (lastEle < arr[ind]) {
                list.add(arr[ind]);
            } else {
                
                int index = bs(list, arr[ind]);
                // System.out.println(index + "index" + " " + arr[ind]);
                list.set(index, arr[ind]);
            }
            
        }
        
        return list.size();
        
    }
    
    static int bs(ArrayList<Integer> list, int ele) {
        
        int left = 0;
        int right = list.size()-1;
        
        while (left < right) {
            
            int mid = (left + right) / 2;
            
            if (list.get(mid) == ele) {
                return mid;
            } 
            
            if (ele > list.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    
    
    
    
}









