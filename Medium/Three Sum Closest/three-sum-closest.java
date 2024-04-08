//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int target = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        		array[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.threeSumClosest(array,target));
            t--;
        }
    } 
} 

// } Driver Code Ends




//User function Template for Java

class Solution 
{ 
    static int threeSumClosest(int[] array, int target)  
	{ 
        // code here
        
        Arrays.sort(array);
        int n = array.length;
        int closeSum = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            
            int sum = 0;
            int x = i+1;
            int y = n-1;
            
            while(x < y) {
                sum = array[i] + array[x] + array[y];
                if(sum == target) {
                    return sum;
                }else if(sum < target) {
                    x++;
                }else {
                    y--;
                }
                
                if(Math.abs(target - closeSum) > Math.abs(target - sum)) {
                    closeSum = sum;
                }else if(Math.abs(target - closeSum) == Math.abs(target - sum)) {
                    closeSum = Math.max(closeSum, sum);
                }
            }
            
        }
        
        
        return closeSum;
        
        
	} 
} 
