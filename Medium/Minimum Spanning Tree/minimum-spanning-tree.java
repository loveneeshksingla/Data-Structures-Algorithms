//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java



class DisjointSet {
    
    private int[] parent;
    private int[] rank;
    
    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        
        for(int ind = 0; ind < size; ind++) {
            parent[ind] = ind;
            rank[ind] = 0;
        }
    }
    
    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY) {
            if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            }else if(rank[rootY] < rank[rootX]) {
                parent[rootY] = rootX;
            }else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}


class Edge {
    int src;
    int dest;
    int wght;
    
    public Edge(int src, int dest, int wght) {
        this.src = src;
        this.dest = dest;
        this.wght = wght;
    }

}

class NewComp implements Comparator<Edge> {
    
    public int compare(Edge e1, Edge e2) {
        return e1.wght - e2.wght;
    }
}

class Solution{
static int spanningTree(int V, int E, int edges[][]) {
    PriorityQueue<Edge> que = new PriorityQueue<>(new NewComp());
    
    // Add all edges to the priority queue
    for (int ind = 0; ind < E; ind++) {
        int u = edges[ind][0];
        int v = edges[ind][1];
        int wt = edges[ind][2];
        
        que.add(new Edge(u, v, wt));
    }
    
    int weight = 0;
    DisjointSet ds = new DisjointSet(V); // Initialize DisjointSet with V
    
    while (!que.isEmpty()) {
        Edge cueEdge = que.remove();
        int u = cueEdge.src;
        int v = cueEdge.dest;
        int wt = cueEdge.wght;
        
        // Check if including this edge forms a cycle or not
        if (ds.find(u) != ds.find(v)) {
            weight += wt;
            ds.union(u, v);
        }
    }
    
    return weight;
}
}




