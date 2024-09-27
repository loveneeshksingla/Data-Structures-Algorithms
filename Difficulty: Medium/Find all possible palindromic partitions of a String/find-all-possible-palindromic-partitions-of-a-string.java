//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> cur = new ArrayList<>();
        
        solve(ans, cur, S, 0);
        
        return ans;
    }
    
    
    static void solve(ArrayList<ArrayList<String>> ans, ArrayList<String> cur, String s, int ind) {
        
        
        if(ind == s.length()) {
            ans.add(new ArrayList(cur));
            return;
        }
        
        String temp = "";
        
        for(int i = ind; i < s.length(); i++) {
            temp += s.charAt(i);
            if(isPalindrome(temp)) {
                cur.add(temp);
                solve(ans, new ArrayList(cur), s, i+1);
                cur.remove(cur.size()-1);
            }
        }
        
    }
    
    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;
        
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
};




