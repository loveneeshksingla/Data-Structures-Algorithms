//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    
    int node;
    int par;
    int wt;
    
    public Pair(int wt, int node, int par) {
        this.node = node;
        this.par = par;
        this.wt = wt;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.

	    
	    PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> a.wt - b.wt);
	    
	    boolean[] vis = new boolean[V];
	    
	    que.add(new Pair(0, 0, -1));
	    
	    int sum = 0;
	    
	    while(!que.isEmpty()) {
	        
	        Pair curPair = que.remove();
	        
	        int curNode = curPair.node;
	        int curwt = curPair.wt;
	        int curPar = curPair.par;
	        
	        
	        
	        if(vis[curNode]) {
	            continue;
	        }
	        
	        vis[curNode] = true;
	        
	        sum += curwt;
	        
	        for(int[] neighbour : adj.get(curNode)) {
	            
	            int curNeighbour = neighbour[0];
	            int curNeighbourWt = neighbour[1];
	            
	            if(!vis[curNeighbour])
	            que.add(new Pair(curNeighbourWt, curNeighbour, curNode));
	            
	            
	        }
	    }
	    
	    return sum;
	
    }
}