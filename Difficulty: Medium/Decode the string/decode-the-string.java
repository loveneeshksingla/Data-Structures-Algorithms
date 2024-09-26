//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static String decodedString(String s){

        StringBuilder result = new StringBuilder();
 
  
        for (int i = 0; i < s.length(); i++) {
      
            if (s.charAt(i) != ']') {
                result.append(s.charAt(i));
            } else {
    
                StringBuilder temp = new StringBuilder();
                while (result.length() > 0 && result.charAt(result.length() - 1) != '[') {
                    temp.insert(0, result.charAt(result.length() - 1));
                    result.deleteCharAt(result.length() - 1);
                }
 
              
                result.deleteCharAt(result.length() - 1);

                StringBuilder num = new StringBuilder();
                while (result.length() > 0 && Character.isDigit(result.charAt(result.length() - 1))) {
                    num.insert(0, result.charAt(result.length() - 1));
                    result.deleteCharAt(result.length() - 1);
                }
                int int_num = Integer.parseInt(num.toString());
 
               
                while (int_num-- > 0) {
                    result.append(temp);
                }
            }
        }
 
        return result.toString();
    }
}