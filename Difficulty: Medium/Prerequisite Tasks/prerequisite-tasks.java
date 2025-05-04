//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		
System.out.println("~");
}
	}
	
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        
        int[] inDegree = new int[N];
        
        for (int ind = 0; ind < N; ind++) {
            graph.add(new ArrayList());
        }
        
        int rowSize = prerequisites.length;
        
        for (int rowInd = 0; rowInd < rowSize; rowInd++) {
            
            int mainTask = prerequisites[rowInd][1];
            int dependentTask = prerequisites[rowInd][0];
            
            inDegree[dependentTask] = inDegree[dependentTask] + 1;
            
            graph.get(mainTask).add(dependentTask);
        }
        
        
        
        
        for (int ind = 0; ind < N; ind++) {
            if (inDegree[ind] == 0) {
                que.add(ind);
            }
        }
        
        while (!que.isEmpty()) {
            
            int curTask = que.remove();
            
            for(Integer neighbour : graph.get(curTask)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    que.add(neighbour);
                }
            }
        }
        
        for (int ind = 0; ind < N; ind++) {
            if (inDegree[ind] != 0) {
                return false;
            }
        }
        
        return true;
        
    }
    
    
    
    
    
    
    
}