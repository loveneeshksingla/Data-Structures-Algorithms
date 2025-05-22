class Solution {
    static int splitArray(int[] arr, int N, int K) {
        // code here
        
        
        int minVal = Integer.MIN_VALUE;
        int maxVal  = 0;
        
        for (int ind = 0; ind < N; ind++) {
            maxVal += arr[ind];
            minVal = Math.max(arr[ind], minVal);
        }
        
        
        while (minVal <= maxVal) {
            int mid = (minVal + maxVal) / 2;
            
            
            boolean isFeasible = isFeasibleVal(arr, mid, N, K);
            
            if (isFeasible) {
                maxVal = mid - 1;
            } else {
                minVal = mid + 1;
            }
            
        }
        
        return minVal;
    }
    
    
    static boolean isFeasibleVal(int[] arr, int val, int N, int k) {
        
        int count = 0;
        int lK = 1;
        
        for (int ind = 0; ind < N; ind++) {
            
            count += arr[ind];
            
            if (count > val) {
                lK++;
                count = arr[ind];
            }
            
            
        }
        
        return lK <= k;
        
    }
};




