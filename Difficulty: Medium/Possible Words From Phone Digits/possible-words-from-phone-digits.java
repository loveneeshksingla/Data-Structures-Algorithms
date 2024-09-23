//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        
        return solve(a, 0, N);
        
        
        
        
    }
    
    
    static ArrayList<String> solve(int[] arr, int curInd, int N) {
        if(curInd == N-1) {
            return getListOfChars(arr[curInd]);
        }
        
        
        int curDigit = arr[curInd];
        
        ArrayList<String> curCharList = getListOfChars(curDigit);
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i = 0; i < curCharList.size(); i++) {
            
            String curChar = curCharList.get(i);
            
            ArrayList<String> res = solve(arr, curInd+1, N);
            
            for(int j = 0; j < res.size(); j++) {
                ans.add(curChar+ res.get(j));
            }
            
        }
        
        return ans;
        
    }
    
    
    
    
    static ArrayList<String> getListOfChars(int num) {
        
        
        ArrayList<String> list = new ArrayList<>();
        
        if(num == 2) 
        {
            list.add("a");
            list.add("b");
            list.add("c");
        }
        
        if(num == 3) 
        {
            list.add("d");
            list.add("e");
            list.add("f");
        }
        
        if(num == 4) 
        {
            list.add("g");
            list.add("h");
            list.add("i");
        }
        
        if(num == 5) 
        {
            list.add("j");
            list.add("k");
            list.add("l");
        }
        
        if(num == 6) 
        {
            list.add("m");
            list.add("n");
            list.add("o");
        }
        
        if(num == 7) 
        {
            list.add("p");
            list.add("q");
            list.add("r");
            list.add("s");
        }
        
        if(num == 8) 
        {
            list.add("t");
            list.add("u");
            list.add("v");
        }
        
        if(num == 9) 
        {
            list.add("w");
            list.add("x");
            list.add("y");
            list.add("z");
        }
        
        return list;
        
    }
}


