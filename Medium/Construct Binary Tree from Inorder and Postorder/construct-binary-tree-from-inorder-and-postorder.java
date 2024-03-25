//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        
        if(n == 0) return null;
        
        int ind = 0;
        
        for(  ; ind < n; ind++) {
            if(in[ind] == post[n-1]) {
                break;
            }
        }
        
        int[] in1 = new int[ind];
        int[] po1 = new int[ind];
        int[] in2 = new int[n-(ind+1)];
        int[] po2 = new int[n-(ind+1)];
        
        for(int i = 0; i < ind; i++) {
            in1[i] = in[i];
            po1[i] = post[i];
        }
        
        int x = 0;
        for(int i = ind+1; i < n; i++) {
            in2[x++] = in[i];
        }
        
        int y = 0;
        for(int i = ind; i < n-1; i++) {
            po2[y++] = post[i];
        }
        
        Node root = new Node(in[ind]);
        root.left = buildTree(in1, po1, ind);
        root.right = buildTree(in2, po2, in2.length);
        
        return root;
    }
    
}













