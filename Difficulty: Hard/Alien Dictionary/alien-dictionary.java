//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends


// User function Template for Java
class Solution {
    public String findOrder(String[] words) {
        // code here
        
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for (int ind = 0; ind < 26; ind++) {
            list.add(new ArrayList());
        }
        
        
        for (int ind = 1; ind < words.length; ind++) {
            
            String firstS = words[ind-1];
            String secS = words[ind];
            
            int firstSLen = firstS.length();
            int secSLen = secS.length();
            
            int minLen = Math.min(firstSLen, secSLen);
            
            for (int sInd = 0; sInd < minLen; sInd++) {
                
                if (firstS.charAt(sInd) != secS.charAt(sInd)) {
                    int firstChar = firstS.charAt(sInd) - 'a';
                    int secChar = secS.charAt(sInd) - 'a';
                    
                    list.get(firstChar).add(secChar);
                    break;
                }
            }
        }
        for (int i = 1; i < words.length; i++) {
    String w1 = words[i - 1];
    String w2 = words[i];
    if (w1.startsWith(w2) && w1.length() > w2.length()) {
        return ""; // Invalid order
    }
}

        
        
        int[] inDegree = new int[26];
        
        
        
                
        for (int ind = 0; ind < 26; ind++) {
            inDegree[ind] = -1;
        }
        
                for (String word : words) {
    for (char ch : word.toCharArray()) {
        int idx = ch - 'a';
        if (inDegree[idx] == -1) {
            inDegree[idx] = 0;
        }
    }
}
        
        for (int ind = 0; ind < 26; ind++) {
            
            for (Integer neighbours : list.get(ind)) {
                if (inDegree[neighbours] == -1) {
                    inDegree[neighbours] = 0;
                }
                
                if (inDegree[ind] == -1) {
                    inDegree[ind] = 0;
                }
                
                inDegree[neighbours]++;
            }
            
        }
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        String ans = "";
        
        for (int ind = 0; ind < 26; ind++) {
            
            if (inDegree[ind] == 0) {
                que.add(ind);
            }
        }
        
        
        while(!que.isEmpty()) {
            
            int curCha = que.remove();
            // System.out.println(curCha + "<====");
            ans += (char)(curCha + 'a');
            
            for (Integer neighbour : list.get(curCha)) {
                inDegree[neighbour]--;
                
                if(inDegree[neighbour] == 0) {
                    que.add(neighbour);
                }
            }
            
            
        }
        
        
        if (ans.length() != countNonNegative(inDegree)) {
    return ""; // Cycle detected, invalid order
}

return ans;
        
    }
    
    private int countNonNegative(int[] arr) {
    int count = 0;
    for (int val : arr) {
        if (val >= 0) {
            count++;
        }
    }
    return count;
}
}













//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends