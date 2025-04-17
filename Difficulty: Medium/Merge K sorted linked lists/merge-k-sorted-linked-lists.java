//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.next = newNode;
                        temp = temp.next;
                    }
                }

                lists.add(head);
            }

            Solution sol = new Solution();
            Node head = sol.mergeKLists(lists);

            printList(head);
            System.out.println("~");
        }
        scanner.close();
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

// arr is an array of Nodes of the heads of linked lists

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        if (arr == null || arr.size() == 0) return null;

        Node result = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            result = merge(result, arr.get(i));
        }

        return result;
    }
    
    Node merge(Node root1, Node root2) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        
        while (root1 != null && root2 != null) {
            if (root1.data < root2.data) {
                prev.next = root1;
                prev = prev.next;
                root1 = root1.next;
                prev.next = null;
                
            } else {
                prev.next = root2;
                prev = prev.next;
                root2 = root2.next;
                prev.next = null;
                
            }
        }
        
        if (root1 != null) {
            prev.next = root1;
        }
        if (root2 != null) {
            prev.next = root2;
        }
        
        return dummy.next;
    }
}




