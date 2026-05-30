/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    boolean isBal;
    public boolean isBalanced(Node root) {
        // code here
        
        isBal = true;
        
        solve(root);
        
        return isBal;
        
    }
    
    public int solve(Node root) {
        
        if (root == null) {
            return 0;
        }
        
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        if (Math.abs(left - right) > 1) {
            isBal = false;
        }
        
        return 1 + Math.max(left, right);
    }
}





