//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution
{
   
    String reverseWords(String S)
    {
        // your code here
        String ans = "";
        
        int i = 0;
        
        while(i < S.length())
        {
            String temp = "";
            while(i < S.length() && S.charAt(i) != '.') {
                temp = S.charAt(i) + temp;
                i++;
            }
            if(i != S.length())
            temp += ".";
            
            ans += temp;
            i++;
            
        }
        return ans;
        
        
        
    }
}