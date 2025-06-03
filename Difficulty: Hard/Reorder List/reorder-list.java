

/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    
    void reorderlist(Node head) {
        // Your code here
        
        Node dummy = new Node(0);
        Node prev = dummy;
        Node mid = findMid(head);
        
        
        Node list2 = mid.next;
        mid.next = null;
        
        Node list1 = head;
        list2 = reverseList(list2);
        
        Node dumm = new Node(0);
        Node pre = dumm;
        
        while(list1 != null && list2 != null) {
            pre.next = list1;
            pre = pre.next;
            list1 = list1.next;
            
            pre.next = list2;
            pre = pre.next;
            list2 = list2.next;
        }
        
        pre.next = list1;
        
        head = dumm.next;
        
    }
    
    
    Node reverseList(Node head) {
        
        Node next = null;
        Node cur = head;
        
        while(cur != null) {
            Node temp = cur;
            cur = cur.next;
            temp.next = next;
            next = temp;
        }
        
        return next;
        
    }
    
    Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
}







