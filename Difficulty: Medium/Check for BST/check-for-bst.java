/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    
    public boolean isBST(Node root) {
        // code here
        
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    
    public boolean solve(Node root, int min, int max) {
        
        
        if (root == null) return true;
        
        if (root.data <= min || root.data >= max) {
            return false;
        }
        
        
        boolean c1 = solve(root.left, min, root.data);
        boolean c2 = solve(root.right, root.data, max);
        
        return c1 && c2;
        
    }
    
    
}