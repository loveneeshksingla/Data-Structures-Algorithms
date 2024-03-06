//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    
    
    boolean[] safeNodes;
    
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        
        
        boolean[] vis = new boolean[V];
        safeNodes = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                boolean[] par = new boolean[V];
                dfs(adj, i, vis, par);
            }
        }
        
        
        for(int i = 0; i < V; i++) {
            if(safeNodes[i]) {
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    
    boolean dfs(List<List<Integer>> adj, int curNode, boolean[] vis, boolean[] par) {
        
        vis[curNode] = true;
        par[curNode] = true;
        
        boolean isSafe = true;
        
        for(int neighbour : adj.get(curNode)) {
            if(!vis[neighbour]) {
                boolean res = dfs(adj, neighbour, vis, par);
                isSafe = isSafe && res;
            }else{
                if(par[neighbour] || !safeNodes[neighbour]) {
                    return false;
                }
            }
        }
        
        
        safeNodes[curNode] = isSafe;
        par[curNode] = false;
        
        return isSafe;
    }
    
    
}




