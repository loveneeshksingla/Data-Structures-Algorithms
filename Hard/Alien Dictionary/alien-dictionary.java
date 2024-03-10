//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<ArrayList<Integer>> adj;
    String ansStr;
    
    public String findOrder(String [] dict, int N, int K)
    {
        createGraph(dict, K);
        ansStr = "";
        int source = dict[0].charAt(0) - 'a';
        boolean[] vis = new boolean[K];
        vis[source] = true;
        bfs(adj, source, K);
        // System.out.print(ansStr);
        return ansStr;
        

    }
    
    public void bfs(ArrayList<ArrayList<Integer>> adj, int source, int K) {
        
        
        int[] inDeg = new int[K];

        
        for(int i = 0; i < K; i++) {
            for(int neighbour : adj.get(i)) {
                inDeg[neighbour]++;
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < K; i++) {
            if(inDeg[i] == 0) {
                que.add(i);
            }
        }
        
        while(!que.isEmpty()) {
            int curNode = que.remove();
            ansStr = ansStr + (char)(curNode + 'a');
            for(int neighbour : adj.get(curNode)) {
                inDeg[neighbour]--;
                if(inDeg[neighbour] == 0) {
                    que.add(neighbour);
                }
            }
        }
        
        
    }
    

    public void createGraph(String[] dict, int K) {
        
        adj = new ArrayList<>();
        for(int ind = 0; ind < K; ind++) {
            adj.add(new ArrayList());
        }
        int dictLen = dict.length;
        
        for(int i = 1; i < dictLen; i++) {
            String str1 = dict[i-1];
            String str2 = dict[i];
            int str1Len = str1.length();
            int str2Len = str2.length();
            int length = Math.min(str1Len, str2Len);
            
            for(int j = 0; j < length; j++) {
                if(str1.charAt(j) != str2.charAt(j)) {
                    int firstStrCharInd = str1.charAt(j) - 'a';
                    int secondStrCharInd = str2.charAt(j) - 'a';
                    adj.get(firstStrCharInd).add(secondStrCharInd);
                    break;
                }
            }
            
        }
    }
}








