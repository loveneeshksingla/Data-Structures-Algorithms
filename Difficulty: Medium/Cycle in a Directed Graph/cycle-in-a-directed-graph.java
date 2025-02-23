//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    boolean isCycle = false;
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int graphSize = adj.size();
        
        boolean[] vis = new boolean[graphSize];
        
        for (int vertex = 0; vertex < graphSize; vertex++) {
            if(!vis[vertex]) {
                boolean[] curVis = new boolean[graphSize];
                curVis[vertex] = true;
                solve(adj, vertex, vis, curVis);
            }
        }
        
        return isCycle;
    }
    
    public void solve(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, boolean[] curVis) {
        
        if( vis[node]) return;
        vis[node] = true;
        
        for( int neighbour : adj.get(node)) {
            if (curVis[neighbour]) {
                isCycle = true;
                break;
            }
            curVis[neighbour] = true;
            solve(adj, neighbour, vis, curVis);
            curVis[neighbour] = false;
        }
    }
}



