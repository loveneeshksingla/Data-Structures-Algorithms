


class Solution {
    int maxProduct(int[] arr) {
        // code here
        
        int arrSize = arr.length;
        
        int max = Integer.MIN_VALUE;
        
        int curProd = 1;
        
        for (int ind = 0; ind < arrSize; ind++) {
            
            curProd = curProd * arr[ind];
        
            
            max = Math.max(max, curProd);
            
            if (curProd == 0) {
                curProd = 1;
            }
        }
        
        curProd = 1;
        for (int ind = arrSize-1; ind >= 0; ind--) {
            curProd = curProd * arr[ind];
        
            
            max = Math.max(max, curProd);
            
            if (curProd == 0) {
                curProd = 1;
            }
            
        }
        
        return max;
        
    }
}