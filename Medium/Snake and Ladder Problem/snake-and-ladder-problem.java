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
    
    static HashMap<Integer, Integer> snakeMap;
    static HashMap<Integer, Integer> ladderMap;
    
    static int minThrow(int N, int arr[]){
        // code here
        
        
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
        
        int count = 0;
        int index = 0;
        
        while(index < N) {
            ladderMap.put(arr[index], arr[index+1]);
            index = index + 2;
            count++;
        }
        
        if(count < N) {
            while(index < 2*N) {
                snakeMap.put(arr[index], arr[index+1]);
                index = index + 2;
            }
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
                    
                    if(snakeMap.containsKey(nextPlace)) {
                        nextPlace = snakeMap.get(nextPlace);
                        if(board[nextPlace] > board[curPlace] + 1) {
                            board[nextPlace] = board[curPlace] + 1;
                            que.add(nextPlace);
                        }
                    }else if(ladderMap.containsKey(nextPlace)) {
                        nextPlace = ladderMap.get(nextPlace);
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





