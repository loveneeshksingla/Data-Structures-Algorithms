//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends




/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		
		if(x  == 0) return 0;
		
		long m = x / 2;
		
		long l = 1;
		long r = m;
		long ans = 1;
		
		while(l <= r) {
		    long mid = (l + r) / 2;
		    
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
