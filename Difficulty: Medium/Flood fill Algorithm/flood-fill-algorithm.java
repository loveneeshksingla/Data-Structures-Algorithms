//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        
        if (image[sr][sc] == newColor) return image;
        
        solve(image, sr, sc, newColor, image[sr][sc]);
        
        return image;
    }
    
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
     
    public boolean areValidIndices(int[][] image, int sr, int sc, int oldColor) {
        int totalRows = image.length;
        int totalCols = image[0].length;
        
        return (sr >= 0 && sc >= 0 && sr < totalRows && sc < totalCols && image[sr][sc] == oldColor);
    }
    
    
    public void solve(int[][] image, int sr, int sc, int newColor, int oldColor) {
        
        boolean areValidIndexs = areValidIndices(image, sr, sc, oldColor);
        if(!areValidIndexs) return ;
        
        image[sr][sc] = newColor;
        
        for (int dirInd = 0; dirInd < 4; dirInd++) {
            
            int curSR = sr + dx[dirInd];
            int curSC = sc + dy[dirInd];
            
            solve(image, curSR, curSC, newColor, oldColor);
        }
    }
}



