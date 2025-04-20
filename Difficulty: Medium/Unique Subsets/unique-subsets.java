//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		
System.out.println("~");
}
	}
}
// } Driver Code Ends




class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        
        Arrays.sort(arr);
        ArrayList <ArrayList <Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curList = new ArrayList<>();
      
        solve(arr, n, 0, ans, curList);
        
        return ans;
        
    }
    
    public static void solve(int[] arr, int n, int curInd, ArrayList <ArrayList <Integer>> ans, ArrayList<Integer> curList) {
        
        if(!ans.contains(curList)) {
            ans.add(new ArrayList<>(curList));
        }
        
        for(int ind = curInd; ind < n; ind++) {
            curList.add(arr[ind]);
            solve(arr, n, ind+1, ans, curList);
            curList.remove(curList.size()-1);
        }
        
    }
}






