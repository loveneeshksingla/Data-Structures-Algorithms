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
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    boolean[] safeNode;
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        boolean[] visit = new boolean[V];
        safeNode = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int ind = 0; ind < V; ind++) {
            boolean[] curPath = new boolean[V];
            if(!visit[ind]) {
                dfs(adj, ind, visit, curPath);
            }
        }
        
        for (int ind = 0; ind < V; ind++) {
            if(safeNode[ind]) {
                ans.add(ind);
            }
        }
        return ans;

    }
    
    
    boolean dfs(List<List<Integer>> adj, int curNode, boolean[] visit, boolean[] curPath) {
        
        curPath[curNode] = true;
        boolean isSafe = true;
        for (Integer neighbour: adj.get(curNode)) {
            if (!visit[neighbour]) {
                visit[neighbour] = true;
                boolean res = dfs(adj, neighbour, visit, curPath);
                isSafe = isSafe && res;
            } else if (curPath[neighbour] || !safeNode[neighbour]){
                return false;
            }
        }
        
        safeNode[curNode] = isSafe;
        curPath[curNode] = false;
        return isSafe;
    }
    
    
}
