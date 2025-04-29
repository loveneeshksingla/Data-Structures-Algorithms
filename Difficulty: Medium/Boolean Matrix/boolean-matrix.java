//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine()); // Read the number of test cases

        while (t-- > 0) {
            int r = Integer.parseInt(read.readLine()); // Number of rows
            int c = Integer.parseInt(read.readLine()); // Number of columns
            int[][] matrix = new int[r][c];

            // Read each row of the matrix
            for (int i = 0; i < r; i++) {
                String line =
                    read.readLine().trim(); // Read the line and remove extra spaces
                String[] elements = line.split(" "); // Split the line by spaces
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = Integer.parseInt(
                        elements[j]); // Parse each element into an integer
                }
            }

            // Call the function to modify the matrix
            new Solution().booleanMatrix(matrix);

            // Output the modified matrix
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(matrix[i][j] +
                                     " "); // Print each element of the matrix
                }
                System.out.println();
            }

            System.out.println("~"); // Print the delimiter
        }
    }
}
// } Driver Code Ends






//User function Template for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        // code here 
        int R = matrix.length;
        int C = matrix[0].length;
        
        int[] row = new int[R];
        int[] col = new int[C];
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(matrix[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                
                if(row[i] == 1) {
                    matrix[i][j] = 1;
                }
                
                if(col[j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        
        
        
    }
}