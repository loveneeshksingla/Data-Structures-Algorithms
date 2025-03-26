//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline

        while (t-- > 0) {
            String input = sc.nextLine(); // Input array as a space-separated string
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            // Parse the input array
            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr));
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int arrSize = arr.length;
        int curSum = 0;
        int count = 0;
        int lastZeroInd = 0;
        map.put(0, 1);
        for (int ind = 0; ind < arrSize; ind++) {
            
            // if (arr[ind] == 0) {
            //     lastZeroInd = ind;
            //     while(ind < arrSize && arr[ind] == 0) {
            //         count++;
            //         count += ind - lastZeroInd;
            //         ind++;
            //     }
            //     ind--;
            // } else {
                curSum += arr[ind];
                if (map.containsKey(curSum)) {
                    count += map.get(curSum);
                    map.put(curSum, map.get(curSum)+1);
                } else {
                    map.put(curSum, 1);
                }
            // }
            
        }
        
        return count;
    }
}
