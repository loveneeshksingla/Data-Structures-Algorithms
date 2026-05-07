



class Solution {
    
    
    public int kthElement(int a[], int b[], int k) {
        // code here
        
        
        
        int aInd = 0;
        int bInd = 0;
        int aSize = a.length;
        int bSize = b.length;
        
        int count = 0;
        
        int ele = -1;
        
        while (aInd < aSize && bInd < bSize && count < k) {
            
            
            if (a[aInd] < b[bInd]) {
                ele = a[aInd];
                aInd++;
            } else {
                ele = b[bInd];
                bInd++;
            }
            
            count++;
            
        }
        
        while (aInd < aSize && count < k) {
            ele = a[aInd++];
            count++;
        }
        
        while (bInd < bSize && count < k) {
            ele = b[bInd++];
            count++;
        }
        
        return ele;
    }
}