//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        
        solve(s);
        return s;
    }
    
    
    public void solve(Stack<Integer> s) {
        if(s.isEmpty()) return;
        
        int ele = s.pop();
        solve(s);
        insertInSortedWay(s, ele);
        
    }
    
    public void insertInSortedWay(Stack<Integer> s, int ele) {
        if(s.isEmpty()) {
            s.push(ele);
            return;
        }
        
        if(ele < s.peek()) {
            int top = s.pop();
            insertInSortedWay(s, ele);
            s.push(top);
        }else {
            s.push(ele);
        }
    }
}