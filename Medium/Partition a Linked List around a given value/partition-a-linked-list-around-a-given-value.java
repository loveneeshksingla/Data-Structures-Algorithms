//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends




// User function Template for Java

/*class Node
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
    public static Node partition(Node node, int x) {
        // Your code here
        
        Node smallerHead = null;
        Node smallerLast = null;
        Node equalHead = null;
        Node equalLast = null;
        Node greaterHead = null;
        Node greaterLast = null;
        
        while(node != null) {
            if(node.data ==x) {
                if(equalHead == null) {
                    equalHead = equalLast = node;
                }else {
                    equalLast.next = node;
                    equalLast = equalLast.next;
                }
            }else if(node.data < x) {
                if(smallerHead == null) {
                    smallerHead = smallerLast = node;
                }else {
                    smallerLast.next = node;
                    smallerLast = smallerLast.next;
                }
            }else {
                if(greaterHead == null) {
                    greaterHead = greaterLast = node;
                }else {
                    greaterLast.next = node;
                    greaterLast = greaterLast.next;
                }
            }
            node = node.next;
        }
        
        if(greaterLast != null) {
            greaterLast.next = null;
        }
        
        if(smallerHead == null) {
            if(equalHead == null) {
                return greaterHead;
            }
            equalLast.next = greaterHead;
            return equalHead;
        }
        
        if (equalHead == null) { 
            smallerLast.next = greaterHead; 
            return smallerHead; 
        } 
        
        smallerLast.next = equalHead; 
        equalLast.next = greaterHead; 
        return smallerHead; 
        
    }
}







