//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        
        Queue<Integer> que = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        
        vis[c] = true;
        for (Integer neighbour : adj.get(c)) {
            if (neighbour != d) {
                que.add(neighbour);
                vis[neighbour] = true;
            }
        }
        
        while(!que.isEmpty()) {
            int curEle = que.remove();
            for (Integer neighbour : adj.get(curEle)) {
                if (!vis[neighbour]) {
                    que.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        
        
        for (int ind = 0; ind < V; ind++) {
            if (vis[d]) {
                return 0;
            }
        }
        
        return 1;
    }
}





