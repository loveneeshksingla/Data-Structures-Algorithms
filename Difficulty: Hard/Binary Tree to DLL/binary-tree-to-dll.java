

//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL


class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    
    Node dummy, prev;
    
    Node bToDLL(Node root)
    {
	    dummy = new Node(0);
	    prev = dummy;
	    solve(root);
	    Node ans = dummy.right;
	    ans.left = null;
	    return ans;
    }
    
    void solve(Node root) {
        if(root == null) return;
        solve(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        solve(root.right);
    }
}




















