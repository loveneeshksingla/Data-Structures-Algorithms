//{ Driver Code Starts
// Initial Template for Java.
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the line of integers (prices)
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        
        
        int profit = 0;
        
        int buyAt = prices[0];
        
        int pricesSize = prices.length;
        
        for (int ind = 1; ind < pricesSize; ind++) {
            
            if (prices[ind] > buyAt) {
                profit += prices[ind] - buyAt;
                buyAt = prices[ind];
            } else {
                buyAt = prices[ind];
            }
        }
        
        return profit;
    }
}