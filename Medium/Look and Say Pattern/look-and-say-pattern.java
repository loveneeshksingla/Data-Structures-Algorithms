//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends




//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        
        String str = "1";
        
        for(int i = 2; i <= n; i++) {
            String ns = "";
            String prev = str.charAt(0) + "";
            int count = 1;
            for(int j = 1; j < str.length(); j++) {
                String cur = str.charAt(j)+"";
                if(cur.equals(prev)) {
                    count++;
                }else {
                    ns += count + "" + prev;
                    prev = str.charAt(j)+"";
                    count = 1;
                }
            }
            str = ns + count + prev;
        }
        

        return str;
        
    }
}
