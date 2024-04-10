//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends




/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    
	    TreeMap<Integer, Integer> Map = new TreeMap<>();
	   // Node newHead = null;
	   // Node tail = null;
	   
	   
	   while(head1 != null) {
	       if(!Map.containsKey(head1.data)) {
	           Map.put(head1.data, 1);
	       }
	       head1 = head1.next;
	   }
	    
	    while(head2 != null) {
	       if(!Map.containsKey(head2.data)) {
	           Map.put(head2.data, 1);
	       }
	       head2 = head2.next;
	   }

        Node newHead = null;
        Node tail = null;
        for(Map.Entry<Integer, Integer> entry : Map.entrySet()) {
            if(newHead == null) {
                newHead = new Node(entry.getKey());
                tail = newHead;
            }else {
                tail.next = new Node(entry.getKey());
                tail = tail.next;
            }
        }
	    
	    return newHead;
	    
	}
}