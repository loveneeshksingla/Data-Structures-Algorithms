//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends




/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        
        Arrays.sort(arr);
        for(int ind = 0; ind < n-2; ind++)  {
            int sum = arr[ind];
            
            int left  = ind+1;
            int right = n-1;
            
            while(left < right) {
                if(sum + arr[left] + arr[right] == 0) {
                    return true;
                }else if(sum + arr[left] + arr[right] > 0)  {
                    right = right -1;
                }else {
                    left++;
                }
            }
        }
        
        
        return false;
        
        
    }
}