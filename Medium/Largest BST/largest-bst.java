//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Pair {
    int size;
    boolean isBST;
    int min;
    int max;
    
    Pair(int size, boolean isBST, int min, int max) {
        this.size = size;
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }
}


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    
    static int max;
    
    static int largestBst(Node root)
    {
        // Write your code here
        max = 1;
        Pair result = findLargestBST(root);
        
        return max;
        
    }
    
    
    
    static Pair findLargestBST(Node root) {
        
        if(root == null) {
            Pair tempPair = new Pair(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
            return tempPair;
        }
        
        
        
        Pair leftRes = findLargestBST(root.left);
        Pair rightRes = findLargestBST(root.right);
    
        Pair curPair = new Pair(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        if(leftRes.size > 0 && (root.data <= root.left.data || root.data <= leftRes.max || leftRes.isBST == false)) {
            curPair.isBST = false;
        }
        
        if(rightRes.size > 0 && (root.data >= root.right.data || root.data >= rightRes.min || rightRes.isBST == false )) {
            curPair.isBST = false;
        }
        
        curPair.size = 1 + leftRes.size + rightRes.size;
        
        curPair.min = Math.min(root.data, leftRes.min);
        curPair.max = Math.max(root.data, rightRes.max);
        
        if(curPair.isBST) {
            max = Math.max(max, curPair.size);
        }
        
        return curPair;
    }
    
    
}






