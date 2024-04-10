//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Pair {
    int ind;
    int freq;
    
    public Pair(int ind, int freq) {
        this.ind = ind;
        this.freq = freq;
    }
}

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        // Comparator<Pair> pairComparator = Comparator.comparingInt(p -> p.ind);
        TreeMap<Character, Pair> map = new TreeMap<>();
        
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(map.containsKey(ch)) {
                Pair curPair = map.get(ch);
                curPair.freq++;
                map.put(ch, curPair);
            }else {
                map.put(ch, new Pair(i, 1));
            }
        }
        
        char ansC = '$';
        int ansInd = Integer.MAX_VALUE;
        
        for(Map.Entry<Character, Pair> entry : map.entrySet()) {
            Pair curP = entry.getValue();
            if(curP.freq == 1 && curP.ind < ansInd)  {
                ansC = entry.getKey();
                ansInd = curP.ind;
            }
            
        }
        
        return ansC;
    }
}











