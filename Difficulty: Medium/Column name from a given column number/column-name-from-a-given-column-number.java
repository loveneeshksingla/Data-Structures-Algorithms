//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends




//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
        String str = "";
        while(n > 0) {
            long rem = n % 26;
            n = n /26;
            if(rem == 0) n = n-1;
            String res= getChar(rem) + "";
            str = res + str;
        }
        return str;
    }
    
    
    char getChar(long digit) {
        
        if(digit == 0) digit = 26;
        digit = digit -1 ;
        return (char) ('A' + digit);
    }
}