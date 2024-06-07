//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}
// } Driver Code Ends




//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    
    static Node sorted  =null;
    
    public static Node insertionSort(Node head_ref)
    {
        //code here
        
        sorted = null;
        Node current = head_ref;
        
        while(current != null) {
            Node next = current.next;
            
            
            sortedLin(current);
            
            current = next;
        }
        
        
        return sorted;
        
        
    }
    
    
    
    public static void sortedLin(Node root) {
        
        if(sorted == null || sorted.data >= root.data) {
            root.next = sorted;
            sorted = root;
        }else {
            
            Node current = sorted;
            
            while(current.next != null && current.next.data < root.data) {
                
                
                current = current.next;
            }
            
            
            root.next = current.next;
            current.next = root;
            
            
            
        }
        
        
    }
    
    
    
}