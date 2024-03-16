//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Pair {
    int num;
    int freq;
    
    public Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}

class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        
        PriorityQueue<Pair> que = new PriorityQueue<>(new Comp());
        
        Arrays.sort(nums);
        int numsLen = nums.length - 1;
        
        int count = 1;
        for(int ind = 1; ind <= numsLen; ind++) {
            if(nums[ind-1] != nums[ind]) {
                que.add(new Pair(nums[ind-1], count));
                count = 0;
            }
            count++;
        }
        
        if(count != 0) que.add(new Pair(nums[numsLen], count));
        
        int[] ans = new int[k];
        
        for(int ind = 0; ind < k; ind++) {
            Pair curPair = que.remove();
            ans[ind] = curPair.num;
        }
        
        return ans;
    }
}


class Comp implements Comparator<Pair> {
    
    @Override 
    public int compare(Pair p1, Pair p2) {
        
        if(p2.freq != p1.freq) {
            return p2.freq - p1.freq;
        }else  {
            return p2.num - p1.num;
        }
        
    }
}




