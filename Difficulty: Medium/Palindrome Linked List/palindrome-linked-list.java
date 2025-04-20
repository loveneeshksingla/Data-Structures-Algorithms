//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {
        // Your code here
        
        
        Node temp = head;
        int listSize = 0;
        
        while (temp != null) {
            listSize++;
            temp = temp.next;
        }
        
        
        if (listSize == 1) return true;
        int count = 1;
        
        temp = head;
        
        while (count < (listSize/2)) {
            temp = temp.next;
            count++;
        }
        
        Node secHead = temp.next;
        
        if (listSize % 2 != 0) {
            secHead = secHead.next;
        }
        temp.next = null;
        
        Node nextHead = null;
        
        while (secHead != null) {
           Node nn = secHead;
           secHead = secHead.next;
           nn.next = nextHead;
           nextHead = nn;
           
           
            
        }
        
        while (head != null && nextHead != null) {
            if (head.data != nextHead.data) {
                return false;
            }
            
            head = head.next;
            nextHead = nextHead.next;
        }
        
        return true;

    }
}







