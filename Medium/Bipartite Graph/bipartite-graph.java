//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends



class Pair {
    int vertex;
    int color;
    
    public Pair(int vertex, int color) {
        this.vertex = vertex;
        this.color = color;
    }
}



class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean[] vis = new boolean[V];
          int[] color = new int[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                boolean ans = solve(i, adj,  vis, color);
                if(!ans)return ans;
            }
        }
        
        return true;
    }
    
    
    public boolean solve(int V, ArrayList<ArrayList<Integer>>adj, boolean[] vis, int[] color)
    {
        // Code here
        Queue<Pair> que = new LinkedList<>();
      
        
        que.add(new Pair(V, 22));
        vis[V] = true;
        color[V] = 22;
   
        
        while(!que.isEmpty()) {
            Pair cur = que.remove();
            ArrayList<Integer> connectedNodes = adj.get(cur.vertex);
            for(int i = 0; i < connectedNodes.size(); i++) {
                int ver = connectedNodes.get(i);
                if(!vis[ver]) {
                    vis[ver] = true;
                    int colr = 22;
                    if(cur.color == 22) {
                        colr = 23;
                    }
                    color[ver] = colr;
                    que.add(new Pair(ver, colr));
                }else {
                    if(color[ver] == cur.color) {
                        return false;
                    }
                }
            }
            
        }
        
        return true;
        
        
    }
    
}