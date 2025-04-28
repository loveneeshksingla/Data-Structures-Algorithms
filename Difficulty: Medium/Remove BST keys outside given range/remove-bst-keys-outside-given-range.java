//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    public static void printInorder(Node node) {
        if (node == null) return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String S[] = br.readLine().split(" ");

            int l = Integer.parseInt(S[0]);
            int r = Integer.parseInt(S[1]);
            String s = br.readLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            Node head = ob.removekeys(root, l, r);
            printInorder(head);
            System.out.print("\n");
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class Solution {
    Node removekeys(Node root, int l, int r) {
        // code here
        
        return solve(root, l, r);
        
    }
    
    
    Node solve(Node root, int min, int max) {
        if (root == null) return null;
        
        root.left = solve(root.left, min, max);
        root.right = solve(root.right, min, max);
        if (root.data < min || root.data > max) {
            root = deleteNode(root, root.data);
        } 
    

        
        return root;
    }
    
    
    Node deleteNode(Node root, int k) {
        
        if (root == null) return null;
        
        if (root.data == k) {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            int data = findleftMax(root.left);
            root.data = data;
            deleteNode(root.left, data);
        } else if (root.data < k) {
            root.right = deleteNode(root.right, k);
        } else {
            root.left = deleteNode(root.left, k);
        }
        
        return root;
    }
    
    int findleftMax (Node root) {
        if (root.right == null) {
            return root.data;
        }
        
        return findleftMax(root.right);
    }
    
    
    
}







