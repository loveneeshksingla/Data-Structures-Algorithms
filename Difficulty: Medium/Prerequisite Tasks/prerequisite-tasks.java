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


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int[] inDegree = new int[N];
        
        boolean[] vis = new boolean[N];
        
        for (int ind = 0; ind < N; ind++) {
            adj.add(new ArrayList());
            inDegree[ind] = 0;
        }
        
        for (int ind = 0; ind < P; ind++) {
            int from = prerequisites[ind][1];
            int to = prerequisites[ind][0];
            adj.get(from).add(to);
            inDegree[to] = inDegree[to] + 1;
        }
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for (int ind = 0; ind < N; ind++) {
            if (inDegree[ind] == 0) {
                que.add(ind);
            }
        }
        
        
        while (!que.isEmpty()) {
            
            int curNode = que.remove();
            
            vis[curNode] = true;
            
            for (Integer neighbour : adj.get(curNode)) {
                inDegree[neighbour] = inDegree[neighbour] - 1;
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







