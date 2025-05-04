//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    
    
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        int edgeSize = edges.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        
        for (int ind = 0; ind < V; ind++) {
            graph.add(new ArrayList());
        }
        
        for (int ind = 0; ind < edgeSize; ind++) {
            
            int main = edges[ind][0];
            int dep = edges[ind][1];
            
            graph.get(main).add(dep);
            
        }
        
        boolean[] vis = new boolean[V];
       
        
        for (int ind = 0; ind < V; ind++) {
            if (!vis[ind]) {
                boolean[] curPath = new boolean[V];
                vis[ind] = true;
                boolean res = dfs(graph, ind, vis, curPath, ind);
                if (res) return res;
            }
        }
        return false;
    }
    
    
    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int curNode, boolean[] vis, boolean[] curPath, int parent) {
        
        
        curPath[curNode] = true;
        for (Integer neighbour : graph.get(curNode)) {
            
            if (!vis[neighbour]) {
                vis[neighbour] = true;
                boolean res = dfs(graph, neighbour, vis, curPath, curNode);
                if (res) return true;
            } else if (curPath[neighbour]) {
                return true;
            }
            
        }
        curPath[curNode] = false;
        return false;
    }
}













