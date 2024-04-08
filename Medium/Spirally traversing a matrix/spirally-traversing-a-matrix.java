//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        
        int x = 0;
        int y = 0;
        
        r = r-1;
        c = c-1;
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while( x <= r && y <= c) {
            
            for(int i = y; i <= c; i++) {
                ans.add(matrix[x][i]);
            }
            
            for(int i = x+1; i<= r; i++) {
                ans.add(matrix[i][c]);
            }
            
            for(int i = c-1; i >= y; i--) {
                if(x != r)ans.add(matrix[r][i]);
            }
            
            for(int i = r-1; i > x; i--) {
                if(y != c)ans.add(matrix[i][y]);
            }
            
            x++;
            y++;
            r--;
            c--;
        }
        
        return ans;
        
        
    }
}
