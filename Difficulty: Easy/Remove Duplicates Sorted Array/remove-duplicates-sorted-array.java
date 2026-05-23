

class Solution {
    
    ArrayList<Integer> removeDuplicates(int[] A) {
        
        int startInd = 1;
        int curEle = A[0];
        int count = 1;
        int N = A.length;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(curEle);
        
        for(int i = 1; i < N; i++) {
            if(A[i] != curEle) {
                A[startInd++] = A[i];
                curEle = A[i];
                count++;
                ans.add(curEle);
            }
        }
        
        
        return ans;
        
    }
}
