/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        
        int carry = 0;
        
        Node ans = null;
        
        while(head1 != null && head2 != null) {
            int curSum = head1.data + head2.data + carry;
            int rem = curSum % 10;
            carry = curSum / 10;
            Node curDigit = new Node(rem);
            
            curDigit.next = ans;
            ans = curDigit;
            
            head1 = head1.next;
            head2 = head2.next;
            
        }
        
        while (head1 != null) {
            int curSum = head1.data  + carry;
            int rem = curSum % 10;
            carry = curSum / 10;
            Node curDigit = new Node(rem);
            curDigit.next = ans;
            ans = curDigit;
            head1 = head1.next;
        }
        
        while (head2 != null) {
            int curSum = head2.data  + carry;
            int rem = curSum % 10;
            carry = curSum / 10;
            Node curDigit = new Node(rem);
            curDigit.next = ans;
            ans = curDigit;
            head2 = head2.next;
        }
        
        if (carry != 0) {
            Node curDigit = new Node(carry);
            curDigit.next = ans;
            ans = curDigit;
        }
        
        
        while (ans != null && ans.data == 0) {
            ans = ans.next;
        }
        return ans;
        
    }
    
    public Node reverseList(Node head) {
        
        Node newHead = null;
        
        
        while (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        
        return newHead;
        
    }
    
    
}





