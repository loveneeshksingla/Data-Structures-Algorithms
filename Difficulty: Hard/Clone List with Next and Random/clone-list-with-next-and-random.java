

/*linked list node
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    
    
    public Node cloneLinkedList(Node head) {
        // code here
        
        Node temp = head;
        
        while (temp != null) {
            Node newNode = new Node(temp.data);
            Node tempNext = temp.next;
            
            temp.next = newNode;
            newNode.next = tempNext;
            temp = newNode.next;
        }
        
        temp = head;
        
        
        
        while (temp != null && temp.next != null) {
            
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            
            temp = temp.next.next;
            
            
        }
        
                
 temp = head;
        Node newHead = head.next;
        Node cloneTemp = newHead;

        while (temp != null) {
            temp.next = temp.next.next;
            if (cloneTemp.next != null) {
                cloneTemp.next = cloneTemp.next.next;
            }
            temp = temp.next;
            cloneTemp = cloneTemp.next;
        }

        return newHead;
        
        
    }
    
    
    
}




















