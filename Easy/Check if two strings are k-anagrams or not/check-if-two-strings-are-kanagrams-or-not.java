//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}
// } Driver Code Ends




//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        
        if(s1.length() != s2.length()) {
            return false;
        }
        
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++) {
            if(map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            }else {
                map.put(s1.charAt(i),1);
            }
        }
        
        int count = 0;
        for(int i = 0; i < s2.length(); i++) {
            if(map.containsKey(s2.charAt(i))) {
               
                map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
                
                
                 if(map.get(s2.charAt(i)) == 0) {
                    map.remove(s2.charAt(i));
                }
                
            }else {
                count++;
            }
        }
        
        
        if(count <= k) {
            return true;
        }
        
        return false;
    }
}