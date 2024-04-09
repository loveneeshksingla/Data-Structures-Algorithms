//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution{
    
    static HashMap<Integer, Integer> snakeLadderMap;

    
    static int minThrow(int N, int arr[]){
        // code here
        
        snakeLadderMap = new HashMap<>();
        
        int count = 0;
        while(count < N) {
            snakeLadderMap.put(arr[2*count], arr[2*count+1]);
            count++;
        }
        
        return bfs(arr);
    }
    
    
    static int bfs(int[] arr) {
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        int[] board = new int[31];
        Arrays.fill(board, Integer.MAX_VALUE);
        
        board[1] = 0;
        que.add(1);
        
        while(!que.isEmpty()) {
            
            int curPlace = que.remove();
            
            for(int diceNum = 1; diceNum <= 6; diceNum++) {
                
                int nextPlace = curPlace + diceNum;
                
                if(nextPlace <= 30) {
                    
                    if(board[nextPlace] > board[curPlace] + 1) {
                        board[nextPlace] = board[curPlace] + 1;
                        que.add(nextPlace);
                    }
                    
                    if(snakeLadderMap.containsKey(nextPlace)) {
                        nextPlace = snakeLadderMap.get(nextPlace);
                        if(board[nextPlace] > board[curPlace] + 1) {
                            board[nextPlace] = board[curPlace] + 1;
                            que.add(nextPlace);
                        }
                    }
                    
                } 
                
            }
        }
        
        return board[30];
    }
    
    
    
    
}




