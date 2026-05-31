


class Solution {
    
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int vInd = 0; vInd < V; vInd++) {
            map.put(vInd, new ArrayList<Integer>());
            inDegree.put(vInd, 0);
        }
        
        int numEdges = edges.length;
        
        for (int edgeInd = 0; edgeInd < numEdges; edgeInd++) {
            
            int u = edges[edgeInd][0];
            int v = edges[edgeInd][1];
            
            ArrayList<Integer> curList = map.get(u);
            curList.add(v);
            
            int curDegree = inDegree.get(v);
            inDegree.put(v, (curDegree+1));
        }
        // System.out.println(map);
        // System.out.println(inDegree);
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            
            if (val == 0) {
                pq.add(key);
            }
        }
        
        while (!pq.isEmpty()) {
            
            int curV = pq.remove();
            
            ans.add(curV);
            
            ArrayList<Integer> list = map.get(curV);
            
            for (Integer curNode: list) {
                int val = inDegree.get(curNode);
                val = val - 1;
                
                inDegree.put(curNode, val);
                
                if (val == 0) {
                    pq.add(curNode);
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            
            int val = entry.getValue();
            
            if (val > 0) {
                
            }
        }
        
        return ans;
    }
}






