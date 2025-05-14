//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class DLL {
    int key;
    int value;
    DLL next;
    DLL prev;
    
    public DLL (int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    
    static DLL dummyHead;
    static DLL tail;
    static int cap;
    static int curLen;
    static HashMap<Integer, DLL> map;

    LRUCache(int cap) {
        // code here
        
        this.cap = cap;
        dummyHead = new DLL(-1, -1);
        tail = new DLL(-1, -1);
        dummyHead.next = tail;
        tail.prev = dummyHead;
        curLen = 0;
        map = new HashMap<>();
        
    }

    public static int get(int key) {

        
        // your code here
        
        if (map.containsKey(key)) {
                
            DLL node = map.get(key);
            int val = node.value;
            
            put(key, node.value);
            
            
            
            return val;
        }
        
        
        
        return -1;
    }

        
    public static void put(int key, int value) {
        // your code here
        

        
        if (map.containsKey(key)) {
            DLL node = map.get(key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
             curLen--;
        }
        
                if (curLen == cap) {
            
            DLL node = tail.prev;
             node.prev.next = node.next;
        node.next.prev = node.prev;
        
        map.remove(node.key);
        //     tail.prev = tail.prev.prev;
        //     tail.prev.prev.next = tail;
            curLen--;
        }


        DLL node = new DLL(key, value);
        
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        node.prev = dummyHead;
        
        map.put(key, node);
        curLen++;
        
    }
    
    
    
    
}









