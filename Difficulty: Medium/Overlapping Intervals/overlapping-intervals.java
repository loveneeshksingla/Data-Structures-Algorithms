//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int numRows = arr.length;
        // for (int i = 0 ; i < numRows; i++) {
        //     System.out.println(arr[i][0] + " " + arr[i][1]);
        // }
        List<int[]> ans = new ArrayList<>();
        
        for (int rowInd = 0; rowInd < numRows-1; rowInd++) {
            
            int[] firstArr = arr[rowInd];
            int[] secArr = arr[rowInd+1];
            
            if (firstArr[1] >= secArr[0]) {
                arr[rowInd+1][1] = firstArr[1] > secArr[1] ? firstArr[1] : secArr[1];
                arr[rowInd+1][0] = firstArr[0] < secArr[0] ? firstArr[0] : secArr[0];
            }else {
                ans.add(new int[] {firstArr[0], firstArr[1]});
            }
        }

        ans.add(new int[] {arr[numRows-1][0], arr[numRows-1][1]});
      
        
        return ans;
    }
}