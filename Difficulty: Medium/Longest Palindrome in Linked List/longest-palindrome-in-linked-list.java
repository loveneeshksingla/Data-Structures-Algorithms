//{ Driver Code Starts
import java.io.*;
import java.lang.Math;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class PalindromeLL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            Node head = new Node(Integer.parseInt(input[0]));
            Node tail = head;
            for (int i = 1; i < input.length; i++) {
                tail.next = new Node(Integer.parseInt(input[i]));
                tail = tail.next;
            }
            Solution ob = new Solution();
            System.out.println(ob.maxPalindrome(head));
        }
    }

    public static Node insert(Node head, int val) {
        if (head == null) return new Node(val);
        head.next = insert(head.next, val);
        return head;
    }

    /*public static void print(Node head){
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }*/
}
// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}*/
class Solution {

            public static int maxPalindrome(Node head)
        {
          //add code here.
          
          Node prev = null;
          Node cur = head;
          int result = 0;
          
          while(cur != null) {
              Node next = cur.next;
              cur.next  = prev;
              result = Math.max(result, 2 * countCommon(prev, next) + 1);
              result = Math.max(result, 2 * countCommon(cur, next));
              prev = cur;
              cur = next;
          }
          
          return result;
          
        }
        
        
        public static int countCommon(Node a, Node b) {
            
            int count = 0;
            
            for( ; a != null && b != null ; a = a.next, b = b.next) {
                if(a.data == b.data) {
                    count++;
                }else {
                    break;
                }
            }
            
            return count;
        }
}