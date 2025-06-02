// User function Template for Java

/*
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

class Solution {
    
    Node first, mid, last, prev;
    public Node correctBST(Node root) {
        // code here.
        
        first = mid = last = prev = null;
        inOrderTraversal(root);
        if (last == null) {
            int temp = first.data;
            first.data = mid.data;
            mid.data = temp;
        }else {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        
        return root;
    }
    
    
    public void inOrderTraversal(Node root) {
        
        if (root == null) {
            return;
        }
        

        
        inOrderTraversal(root.left);
        
        if (prev != null && root.data < prev.data) {
            if(first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }
        
        prev = root;
        
        inOrderTraversal(root.right);
        
    }
}









