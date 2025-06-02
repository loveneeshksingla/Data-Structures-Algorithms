/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        
        int count = 0;
        
        Node prev = null;
        Node tail;
        
        Node newHead = null;
        
        while ( count < k && head != null) {
            // System.out.println(count);
            
            Node newNode = head;
            // System.out.println(newNode.data);
            head = head.next;
            newNode.next = null;
            
            if (prev == null) {
                prev = newNode;
            } else {
                newNode.next = prev;
                prev = newNode;
            }
            
            
            count++;
            if (count == k) {
                count = 0;
                tail = newHead;
                if (newHead == null) {
                    newHead = prev;
                    tail = newHead;
                } else {
                    while(tail.next != null) {
                        tail = tail.next;
                        
                    }
                    tail.next = prev;
                }
                prev = null;
            }
        }
        
        if(prev != null) {
             tail = newHead;
            while(tail.next != null) {
                        tail = tail.next;
                        
                    }
                    tail.next = prev;
        }
        
        return newHead;
    }
}









