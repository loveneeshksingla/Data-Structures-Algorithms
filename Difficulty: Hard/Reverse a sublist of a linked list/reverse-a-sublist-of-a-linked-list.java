// User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    public static Node reverseBetween(int a, int b, Node head) {
        // code here
        
        int count = 1;
        
        Node preva = null;
        Node heada = null;
        
        Node temp = head;
        // Node newtemp = head;
        
        while(count < a) {
            preva = temp;
            heada = temp.next;
            temp = temp.next;
            count++;
        }
        
        if (preva == null && heada == null) {
            heada = head;
        }
        
        if(preva != null) preva.next  = null;
        
        Node prevb = null;
        Node headb = null;
        
        Node newtemp = heada;
        //  System.out.println(newtemp.data + "<====");
        while(count <= b && newtemp != null) {
        //  System.out.println(newtemp.data + "<====");
            prevb = newtemp;
            headb = newtemp.next;
          newtemp = newtemp.next;
          count++;
        }
        if(prevb != null) prevb.next = null;
        
        
        Node newHead = null;
        
        while (heada != null) {
            Node newNode = heada;
            heada = heada.next;
            newNode.next = newHead;
            newHead = newNode;
        }
        
        if (preva != null) {
            preva.next = newHead;
        } else {
            head = newHead;
        }
        
        
        
        Node tail = head;
        
        while(tail.next != null) {
            tail = tail.next;
        }
        
        tail.next = headb;
        
        return head;
        
    }
}