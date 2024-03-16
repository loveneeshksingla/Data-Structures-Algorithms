//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    String printLargest(int n, String[] arr) {
        
        Arrays.sort(arr, new Comp());
        
        String ans = "";
        
        for(int ind = 0; ind < arr.length; ind++) {
            ans += arr[ind];
        }
        
        return ans;
    }
    
    class Comp implements Comparator<String> {
        
        @Override
        public int compare(String x, String y) {
            String s1 = x + y;
            String s2 = y + x;
            
            return s2.compareTo(s1);
        }
    }
    
}