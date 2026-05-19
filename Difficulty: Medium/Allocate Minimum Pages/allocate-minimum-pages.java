class Solution {
    
    public int findPages(int[] arr, int k) {
        // code here
        int minPage =  -1;
        int maxPage = 0;
        
        int arrSize = arr.length;
        
        if (arrSize < k) {
            return -1;
        }
        
        
        for (int ind = 0; ind < arrSize; ind++) {
            minPage = Math.max(minPage, arr[ind]);
            maxPage += arr[ind];
        }
        
        int ans = Integer.MAX_VALUE;
        // System.out.println(minPage + " " + maxPage);
        while (minPage <= maxPage) {
            
            int midPage = (minPage + maxPage) / 2;
            
            if (isFeasible(midPage, arr, k)) {
                maxPage = midPage - 1;
                ans = Math.min(ans, midPage);
            } else {
                minPage = midPage + 1;
            }
        }
        // System.out.println(minPage + " " + maxPage);
        return ans;
        
    }
    
    public boolean isFeasible(int mid, int[] arr, int k) {
        
        int arrSize = arr.length;
        
        int curStu = 1;
        
        int curPages = 0;
        
        for (int ind = 0; ind < arrSize; ind++) {
            
            curPages += arr[ind];
            
            if (curPages > mid)  {
                curStu++;
                curPages = arr[ind];
            }
        }
        
        return curStu <= k;
    }
}






