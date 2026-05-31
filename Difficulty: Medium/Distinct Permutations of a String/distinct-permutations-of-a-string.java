


class Solution {
    
    public ArrayList<String> findPermutation(String s) {
        // Code here
        
        return solve(s);
    }
    
    public ArrayList<String> solve(String s) {
        
        
        if (s.length() == 1) {
            ArrayList<String> newList = new ArrayList<>();
            newList.add(s);
            return newList;
        }
        
        
        int sLen = s.length();
        
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int ind = 0; ind < sLen; ind++) {
            
            char curCh = s.charAt(ind);
            String newStr = s.substring(0, ind) + s.substring(ind+1);
            
            ArrayList<String> curList = solve(newStr);
            
            int curListSize = curList.size();
            
            for (int index = 0; index < curListSize; index++) {
                String listEle = curList.get(index);
                listEle = curCh + listEle;
                
                if (!map.containsKey(listEle)) {
                    ans.add(listEle);
                    map.put(listEle,1);
                }
                
            }
        }
        
        return ans;
        
    }
    
}


