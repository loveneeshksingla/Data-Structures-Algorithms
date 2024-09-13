//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
         List<String> ans = new ArrayList<>();
        String s = "";
 
        // initially we are passing the counts of open and
        // close as 0, and the string s as an empty string.
        generateParenthesis(n, n, s, ans);
        
        return ans;
    }
    
    void generateParenthesis(int left, int right,
                                    String s,
                                    List<String> answer)
    {
 
        // terminate
        if (left == 0 && right == 0) {
            answer.add(s);
        }
 
        if (left > right || left < 0 || right < 0) {
            // wrong
            return;
        }
 
        s += "(";
        generateParenthesis(left - 1, right, s, answer);
        s = s.substring(0, s.length() - 1);
        s += ")";
        generateParenthesis(left, right - 1, s, answer);
        s = s.substring(0, s.length() - 1);
    }
}