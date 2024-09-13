//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends




//User function Template for Java


class TrieNode {
    TrieNode children[];
    boolean isEndOfWord;
    int numOfChild;
    
    TrieNode() {
        children = new TrieNode[26];
        for(int i = 0; i < 26; i++) {
            children[i] = null;
        }
        isEndOfWord = false;
        numOfChild = 0;
    }
    
}

class Solution {
    
    static int count = 0;
    
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        
        TrieNode root = new TrieNode();
        count = 0;
        for(int i = 0; i < N; i++) {
            insertWordInDictionary(root, arr[i]);
        }
        
        
        String[] ans = new String[N];
    
        String[] finalAns = new String[N];
        
        
        String[] newArr = new String[N];
        
        
        for(int i = 0; i < N; i++) {
            newArr[i] = arr[i];
        }
        
        Arrays.sort(newArr);
        solve(root, ans, "");
        
        for(int i = 0; i < N; i++) {
            String curWord = newArr[i];
            // System.out.println(curWord + "<====");
            int index = findIndex(arr, curWord);
            // System.out.println(index + "<===");
            finalAns[index] = ans[i];
        }
        
        
        
        return finalAns;
        
        
    }
    
     public static int findIndex(String[] words, String target) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                return i; // Return the index if the word matches
            }
        }
        return -1; // Return -1 if the word is not found in the array
    }
    
    static void solve(TrieNode root, String[] ans, String str) {
        
        TrieNode cur = root;
        
        for(int i = 0; i < 26; i++) {
            
            TrieNode curChild = cur.children[i];
            if(curChild != null)  {
            if(curChild.numOfChild == 1 || curChild.isEndOfWord) {
                ans[count++] = str + (char)((int)'a'+i);
            }else {
                solve(curChild, ans, new String(str+""+(char)((int)'a'+i)));
            }}
        }
        
    }
    
    
    static void insertWordInDictionary(TrieNode root, String word) {
        
        TrieNode cur = root;
        
        for(int i = 0; i < word.length(); i++) {
            if(cur.children[word.charAt(i)-'a'] == null) {
                TrieNode newNode = new TrieNode();
                cur.children[word.charAt(i)-'a'] = newNode;
            }
            cur.numOfChild++;
            cur = cur.children[word.charAt(i)-'a'];
        }
        
        cur.isEndOfWord = true;
        
    }
    
    
};





