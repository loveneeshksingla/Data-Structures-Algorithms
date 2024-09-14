//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends




class Solution {
    
    
    static int Prec(char ch)
    {
        switch (ch) {
        case '+':
        case '-':
            return 1;
 
        case '*':
        case '/':
            return 2;
 
        case '^':
            return 3;
        }
        return -1;
    }
    
    
    
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        
        
        String result = "";
        int n = exp.length();
        Stack<Character> sta = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            
            char ch = exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)) {
                result += ch+"";
            }else if(ch == '(') {
                sta.push(ch);
            }else if(ch == ')') {
                while(!sta.isEmpty() && sta.peek() != '(') {
                    result += sta.pop();
                }
                sta.pop();
            }else {
                while(!sta.isEmpty() && Prec(ch) <= Prec(sta.peek())) {
                    result += sta.pop();
                }
                sta.push(ch);
            }

        }
         while (!sta.isEmpty()) {
           
            result += sta.peek();
            sta.pop();
        }
        
        return result;
        
        
    }
    
    
    
    
    
    
    
}