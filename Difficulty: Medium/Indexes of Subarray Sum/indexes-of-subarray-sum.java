


class Solution {
    
    
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 0);
        
        int arrSize = arr.length;
        
        int curSum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int ind = 0; ind < arrSize; ind++) {
            
            curSum += arr[ind];
            
            int diff = curSum - target;
            
            if (map.containsKey(diff)) {
              int val = map.get(diff);
              ans.add(val+1);
              ans.add(ind+1);
              return ans;
            } 
            
            if (!map.containsKey(curSum)) {
                map.put(curSum, ind+1);
            }
            
        }
        
        ans.add(-1);
        
        return ans;
    }
    
}
