

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    static ArrayList<Integer> ans;
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ans = new ArrayList<>();
        solve(root, target, k);
        Collections.sort(ans);
        return ans;
        
    }
    
    static int solve(Node root, int target, int k) {
        
        if(root == null) return 0;
        
        if(root.data == target) {
            getNodesAtDis(root, k, 0);
            return 1;
        }
        
        int left = solve(root.left, target, k);
        int right = solve(root.right, target, k);
        
        int depth = Math.max(left, right);
        if(depth > 0) depth++;
        
        if(left > 0 && left <= k) {
            if(left == k) 
                ans.add(root.data);
            else
                getNodesAtDis(root.right, k, left+1);
        }
        
        if(right > 0 && right <= k) {
            if(right == k) 
                ans.add(root.data);
            else 
                getNodesAtDis(root.left, k, right+1);
        }
        
        return depth;
    }
    
    static void getNodesAtDis(Node root, int k, int dis) {
        
        if(root == null || dis > k) return;
        
        if(dis == k) {
            ans.add(root.data);
            return;
        }
        
        getNodesAtDis(root.left, k, dis+1);
        getNodesAtDis(root.right, k, dis+1);
    }
};





