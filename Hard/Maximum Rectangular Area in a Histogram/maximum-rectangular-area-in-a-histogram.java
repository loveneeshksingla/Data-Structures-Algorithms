//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends




class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int arrLen = (int)n;
        long maxArea = hist[0];
        int left_smaller[] = new int[arrLen];
        int right_smaller[] = new int[arrLen];
        
        for (int i = 0; i < n; i++) {
            left_smaller[i] = -1;
            right_smaller[i] = arrLen;
        }
        
        
        int i =0;
        while(i < arrLen) {
            while(!s.isEmpty() && s.peek() != -1 && hist[i] < hist[s.peek()]) {
                
                right_smaller[s.peek()] = i;
                s.pop();
            }
            
            if(i > 0 && hist[i] == hist[i-1]) {
                left_smaller[i] = left_smaller[i-1];
            }else {
                left_smaller[i] = s.peek();
            }
            
            s.push(i);
            i++;
        }
        
        for(i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, hist[i]
                              * (right_smaller[i]
                                 - left_smaller[i] - 1));
        }
        
        return maxArea;
        
    }
        
}



