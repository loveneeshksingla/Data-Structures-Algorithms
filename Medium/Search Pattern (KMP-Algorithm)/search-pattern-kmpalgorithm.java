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
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int patLen = pat.length();
        int txtLen = txt.length();
        
        int[] lpsA = new int[patLen];
        lps(lpsA, pat);
        
        int i = 0;
        int j = 0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while((txtLen-i) >= (patLen-j)) {
            if(txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            
            if(j == patLen) {
                ans.add(i - j + 1);
                j = lpsA[j-1];
            }else if(i < txtLen && txt.charAt(i) != pat.charAt(j)){
                if(j != 0) {
                    j = lpsA[j-1];
                }else{ 
                    i++;
                }
            }
        }
        
        return ans;
    }
    
    
    void lps(int[] lpsA, String pat) {
        int len = 0;
        int i = 1;
        lpsA[0] = 0;
        int n = pat.length();
        
        while(i < n) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lpsA[i++] = len;
            }else {
                if(len != 0) {
                    len = lpsA[len-1];
                }else {
                    lpsA[i] = len;
                    i++;
                }
            }
        }
    }
}


