// class Node
// {
//     int data;
//     Node left, right;
// }

class Solution {
    
    
    static ArrayList<Integer> ans;
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // return the sorted list of all nodes at k dist
        
        ans = new ArrayList<>();
        solve(root, target, k, 0);
        Collections.sort(ans);
        return ans;
    }
    
    
    public static int solve(Node root, int target, int k, int curDis) {
        
        if (root == null) return 0;
        
        
        if (root.data == target) {
            findNodes(root, k, 0);
            return 1;
        }
        
        int left = solve(root.left, target, k, curDis+1);
        int right = solve(root.right, target, k, curDis+1);
        
        int depth = Math.max(left, right);
        if (depth > 0) depth++;
        
        if (left >= 1 && left <= k) {
            
            if (left == k) {
                ans.add(root.data);
               
            } else {
                findNodes(root.right, k, left+1);
            }
            
            
        } else if (right >= 1 && right <= k) {
            
            if (right == k) {
                ans.add(root.data);
               
            } else {
                findNodes(root.left, k, right+1);
            }
            
        }
        
        return depth;
        
        
    }
    
    
    public static void findNodes(Node root, int k, int curDis) {
        
        if (root == null) {
            return;
        }
        
        if (curDis == k) {
            ans.add(root.data);
            return;
        }
        
        findNodes(root.left, k, curDis+1);
        findNodes(root.right, k, curDis+1);
    }
    
    
    
};









