//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair {
    int node;
    int weight;
    
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        getShortestDis(adj, S, dis);
        
        return dis;
    }
    
    static void getShortestDis(ArrayList<ArrayList<ArrayList<Integer>>> adj, int source, int[] dis) {
        
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        
        dis[source] = 0;
        que.add(new Pair(source, 0));
        
        while(!que.isEmpty()) {
            Pair curPair = que.remove();
            
            int curNode = curPair.node;
            int weight = curPair.weight;
            
            for(ArrayList<Integer> list : adj.get(curNode)) {
                
                int neighbour = list.get(0);
                int curWeight = list.get(1);
                
                if(weight + curWeight < dis[neighbour]) {
                    dis[neighbour] = weight + curWeight;
                    que.add(new Pair(neighbour, dis[neighbour]));
                }
            }
        }
    }
}

