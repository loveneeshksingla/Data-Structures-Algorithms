//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    
    boolean isCycle = false;
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int numV = adj.size();
        
        boolean[] vis = new boolean[numV];
        
        for (int i = 0; i < numV; i++) {
            if(!vis[i]) {
                solve(adj, i, vis, -1);
            }
        }
        
        return isCycle;
    }
    
    public void solve(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, int parent) {
        
        if(vis[node]) return;
        vis[node] = true;
        
        
        for (int neighbour:  adj.get(node)) {
            if(vis[neighbour] && neighbour != parent) {
                isCycle = true;
                break;
            }
            solve(adj, neighbour, vis, node);
            
        }
        
        
    }
}