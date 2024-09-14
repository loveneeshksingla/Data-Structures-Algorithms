//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        // code here
        
        if(numerator == 0) {
            return "0";
        }
        
        
        StringBuilder result = new StringBuilder();
         
        
        result.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        
        result.append(num / den);
        
        num = num % den;
        
        if(num == 0) {
            return result.toString();
        }
        
        result.append(".");
        
        Map<Long, Integer> remainderMap = new HashMap<>();
        remainderMap.put(num, result.length());
         
        while(num > 0) {
            num = num * 10;
            result.append(num / den);
            num %= den;
            
             if (remainderMap.containsKey(num)) {
                int index = remainderMap.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                remainderMap.put(num, result.length());
            }
        }
        
        return result.toString();
    }
    
    
    
    
    
    
    

}