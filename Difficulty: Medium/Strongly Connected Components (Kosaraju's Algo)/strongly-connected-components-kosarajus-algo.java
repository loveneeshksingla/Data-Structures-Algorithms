//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends




//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    
    Stack<Integer> sta;
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        
        sta = new Stack<>();
        
        boolean[] vis = new boolean[V];
        
        for(int ind = 0; ind < V; ind++) {
            if(!vis[ind]) {
                vis[ind] = true;
                dfs(adj, ind, vis);
            }
        }
        
        ArrayList<ArrayList<Integer>> newGraph = new ArrayList<>();
        
        for(int ind = 0; ind < V; ind++) {
            newGraph.add(new ArrayList());
        }
        
        for(int ind = 0; ind < V; ind++) {
            for(int neighbour : adj.get(ind)) {
                newGraph.get(neighbour).add(ind);
            }
        }
        
        vis = new boolean[V];
        int count = 0;
        
        while(!sta.isEmpty()) {
            int curNode = sta.pop();
            if(!vis[curNode]) {
                vis[curNode] = true;
                dfs(newGraph, curNode, vis);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int curNode, boolean[] vis) {
        
        for(int neighbour : adj.get(curNode)) {
            if(!vis[neighbour]) {
                vis[neighbour] = true;
                dfs(adj, neighbour, vis);
            }
        }
        
        sta.push(curNode);
        
    }
}
