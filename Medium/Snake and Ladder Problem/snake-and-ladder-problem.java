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
    static HashMap<Integer, Integer> ladderMap;
    static HashMap<Integer, Integer> snakeMap;
    static int minThrow(int N, int arr[]){
        // code here
        
        ladderMap = new HashMap<>();
        snakeMap = new HashMap<>();
        
        int i = 0;
        for( ; i < N-1; i = i + 2) {
            ladderMap.put(arr[i], arr[i+1]);
        }
        
        for( ; i < 2*N-1; i = i + 2) {
            snakeMap.put(arr[i], arr[i+1]);
        }
        
        return solve(arr, N);
        
    }
    
    static int solve(int arr[], int N) {
        
        boolean[] vis = new boolean[31];
        int[] dis = new int[31];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        vis[1] = true;
        
        for(int i = 0; i < 31; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[1] = 0;
        
        while(!que.isEmpty()) {
            int curV = que.remove();
            int curDis = dis[curV];
            
            for(int i = 1; i <= 6; i++) {
                int tempV = curV + i;
                if(tempV <= 30 && dis[tempV] > 1 + curDis) {
                    dis[tempV] = 1 + curDis;
                    if(ladderMap.containsKey(tempV)) {
                        vis[tempV] = true;
                        tempV = ladderMap.get(tempV);
                        if(dis[tempV] > 1 + curDis)
                        dis[tempV] = 1 + curDis;    
                    }else if(snakeMap.containsKey(tempV)){
                        vis[tempV] = true;
                        tempV = snakeMap.get(tempV);
                        if(dis[tempV] > 1 + curDis)
                        dis[tempV] = 1 + curDis;
                    }
                    if(!vis[tempV]) {
                        vis[tempV] = true;
                        que.add(tempV);
                    }
                }
            }
        }
        
        return dis[30];
    } 
}






