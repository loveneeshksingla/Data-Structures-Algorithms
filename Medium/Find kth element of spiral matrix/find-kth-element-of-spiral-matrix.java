//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends




class Solution
{
    /*You are required to complete this method*/
    int findK(int matrix[][], int r, int c, int k)
    {
	// Your code here	
	
	        
        int x = 0;
        int y = 0;
        
        r = r-1;
        c = c-1;
        
        int num = 0;
    
        
        // ArrayList<Integer> ans = new ArrayList<Integer>();
        int count = 0;
        while( x <= r && y <= c) {
            
            for(int i = y; i <= c; i++) {
                // ans.add(matrix[x][i]);
                count++;
                if(k == count) {
                    num = matrix[x][i];
                    break;
                }
            }
            
            for(int i = x+1; i<= r; i++) {
                // ans.add(matrix[i][c]);
                count++;
                //  System.out.print(count + "// " );
                if(k == count) {
                     num = matrix[i][c];
                    break;
                }
            }
            
            for(int i = c-1; i >= y; i--) {
                if(x != r){
                    count++;
                    if(k == count) {
                    num = matrix[r][i];
                    break;
                }
                }
            }
            
            for(int i = r-1; i > x; i--) {
                if(y != c){
                    count++;
                    if(k == count) {
                    num = matrix[i][y];
                    break;
                }
                }
            }
            
            if(count == k) {
                break;
            }
            
            x++;
            y++;
            r--;
            c--;
        }
        

	return num;
	
	
	
    }
}