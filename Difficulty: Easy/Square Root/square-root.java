class Solution {
    int floorSqrt(int x) {
        // code here
        
        		
		if(x  == 0) return 0;
		
		int m = x / 2;
		
		int l = 1;
		int r = m;
		int ans = 1;
		
		while(l <= r) {
		    int mid = (l + r) / 2;
		    
		    if(mid  * mid == x) {
		        return mid;
		    }
		    
		    
		    if(mid * mid  < x) {
		        ans = mid;
		        l = mid + 1;
		    }else {
		        r = mid -1;
		    }
		}
		
		return ans;
    }
}