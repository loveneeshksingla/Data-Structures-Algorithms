class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        
        int startInd = 0;
        int n = arr.length;
        for(int ind = 0; ind < n; ind++) {
            if(arr[ind] != 0) {
                swapEles(arr, startInd, ind);
                startInd++;
            }
        }
    }
    
    void swapEles(int[] arr, int firstInd, int secInd) {
        int tempEle = arr[firstInd];
        arr[firstInd] = arr[secInd];
        arr[secInd] = tempEle;
    }
}