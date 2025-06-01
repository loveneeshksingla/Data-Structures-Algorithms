// User function Template for Java



class Trie {
    Trie children[];
    int numChild;
    
    boolean isEnd;
    
    public Trie() {
        
        children = new Trie[26];
        for(int ind = 0; ind < 26; ind++) {
            children[ind] = null;
        }
        isEnd = false;
        numChild = 0;
    }
}
class Solution {
    static int count = 0;
    
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        
        Trie root = new Trie();
        count = 0;
        String[] newArr = new String[N];
        
        for (int ind = 0; ind < N; ind++) {
            createDic(arr[ind], root);
            newArr[ind] = arr[ind];
        }
        
        Arrays.sort(newArr);
        
        String[] ans = new String[N];
        String[] finalAns = new String[N];
        
        solve(ans, root, "");
        
        for (int ind = 0; ind < N; ind++) {
            
            int index = findIndex(arr, newArr[ind]);
            
            finalAns[index] = ans[ind];
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
    
    
    static void solve(String[] ans, Trie curRoot, String str) {
        
        Trie root = curRoot;
        
        for (int ind = 0; ind < 26; ind++) {
            
            if (root.children[ind] != null) {
                
                if (root.children[ind].numChild == 1 || root.children[ind].isEnd) {
                    ans[count++] = str + (char)((int)'a'+ind);
                } else {
                    solve(ans, root.children[ind], new String(str+""+(char)((int)'a'+ind)));
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    static void createDic(String curStr, Trie curRoot) {
        
        Trie root = curRoot;
        int curStrLen = curStr.length();
        
        for (int ind = 0; ind < curStrLen; ind++) {
            
            int curCharAsccii = curStr.charAt(ind) - 'a';
            
            if (root.children[curCharAsccii] == null) {
                root.children[curCharAsccii] = new Trie();
            }
            root = root.children[curCharAsccii];
            root.numChild++;
       
            
        }
        root.isEnd = true;
        
        
    }
};