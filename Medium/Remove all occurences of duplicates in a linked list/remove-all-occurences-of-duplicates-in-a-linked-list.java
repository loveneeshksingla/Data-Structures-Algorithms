//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class duplicates
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
			int N = sc.nextInt();
			duplicates llist = new duplicates(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.removeAllDuplicates(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }
    
}
// } Driver Code Ends




//User function Template for Java

/* Linked List Node class

class Node
{
    int data;
    Node next;
}
    
*/

class Solution
{
    public static Node removeAllDuplicates(Node head)
    {
        //code here
        // Node prev = head;
        
        if(head == null || head.next == null) {
            return head;
        }
        
        Node temp = head;
        Node prev = null;
        Node newHead = null;
        
        while(temp != null && temp.next != null) {
            if(temp.data != temp.next.data) {
                if(prev == null) {
                    prev = temp;
                    newHead = temp;
                }else {
                    prev.next = temp;
                    prev = prev.next;
                }
                temp = temp.next;
            }else {
                while(temp != null && temp.next != null && temp.data == temp.next.data) {
                    temp = temp.next;
                }
                temp = temp.next;
            }
        }
        
        
        if(prev != null) {
        if(temp != null && prev.data != temp.data) {
            prev.next = temp;
           prev = prev.next;
            
        }
        prev.next = null;}
        
        if(prev == null) return temp;

        return newHead;
    }
}





