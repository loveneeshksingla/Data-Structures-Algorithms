//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void printSpecial(Node root)
    {
       if (root == null)
         return;
    
       Node next_root=null;
    
       while (root != null)
       {
          System.out.print(root.data+" ");
    
          if( root.left!=null && next_root==null )
            next_root = root.left;
          else if( root.right!=null && next_root==null  )
            next_root = root.right;
    
          root = root.nextRight;
       }
       
       printSpecial(next_root);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			    g.connect(root);
                printSpecial(root);
                System.out.println();
                printInorder(root);
                System.out.println();
                t--;
            
        
System.out.println("~");
}
    }
  
}


// } Driver Code Ends


// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
} */


class Pair {
    Node node;
    int level;
    
    public Pair (Node node, int level) {
        this.node = node;
        this.level = level;
    }
}


class Solution {
    
    public void connect(Node root) {
        // code here
        
        int heightOfTree = treeHeight(root);
        
        ArrayList<ArrayList<Node>> nodeLevelList = new ArrayList<>();
        
        for (int ind = 0; ind < heightOfTree; ind++) {
            nodeLevelList.add(new ArrayList());
        }
        
        Queue<Pair> que = new LinkedList<>();
        
        que.add(new Pair(root, 0));
        
        while (!que.isEmpty()) {
            Pair curPair = que.remove();
            
            nodeLevelList.get(curPair.level).add(curPair.node);
            
            if (curPair.node.left != null) {
                que.add(new Pair(curPair.node.left, curPair.level+1));
            }
            
            if (curPair.node.right != null) {
                que.add(new Pair(curPair.node.right, curPair.level+1));
            }
            
        } 
        
        
        for (int ind = 0; ind < heightOfTree; ind++) {
            
            ArrayList<Node> curList = nodeLevelList.get(ind);
            
            Node prevNode = curList.get(0);
            
            for (int i = 1; i < curList.size(); i++) {
                Node nextRight = curList.get(i);
                prevNode.nextRight = nextRight;
                prevNode = prevNode.nextRight;
            }
            
            
        }
        
        
    }
    
    public int treeHeight(Node root) {
        
        if (root == null) return 0;
        
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
        
    }
}








