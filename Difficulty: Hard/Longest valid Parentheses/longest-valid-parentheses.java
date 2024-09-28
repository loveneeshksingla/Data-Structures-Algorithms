//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static int maxLength(String str){
        // code here
        
        int n = str.length();
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
 
        int result = 0;
        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) == '(')
                stk.push(i);
            else
            {
                if(!stk.empty())
                    stk.pop();
                if (!stk.empty())
                    result = Math.max(result, i - stk.peek());
                else
                    stk.push(i);
            }
        }
 
        return result;
    }
}