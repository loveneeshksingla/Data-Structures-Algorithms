class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int V = adj.size();
        boolean[] visited  = new boolean[V];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = true;
        
         ArrayList<Integer> ans  = new ArrayList<>();
        
        while(!que.isEmpty()) {
            int curNode = que.remove();
            
            ans.add(curNode);
            
            for(int neighbour : adj.get(curNode)) {
                if(!visited[neighbour]) {
                    que.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        
        return ans;
        
    }
}