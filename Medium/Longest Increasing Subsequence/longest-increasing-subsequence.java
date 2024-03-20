//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        
        ArrayList<Integer> increasingSeq = new ArrayList<>();
        increasingSeq.add(a[0]);
        
        for(int i = 1; i < size; i++) {
            
            int iSeqLastInd = increasingSeq.size()-1;
            int lastEle = increasingSeq.get(iSeqLastInd);
            
            if(lastEle < a[i]) {
                increasingSeq.add(a[i]);
            }else {
                int ind = binarySearch(increasingSeq, a[i]);
                if(ind < 0) ind = 0;
                increasingSeq.set(ind, a[i]);
            }
        }
        
        return increasingSeq.size();
    }
    
    static int binarySearch(ArrayList<Integer> arrList, int key) {
        
        int leftInd = 0;
        int rightInd = arrList.size()-1;
        
        while(leftInd <= rightInd) {
            int mid = (leftInd + rightInd) / 2;
            
            if(arrList.get(mid) == key) {
                return mid;
            }
            
            if(arrList.get(mid) < key) {
                leftInd = mid + 1;
            }else {
                rightInd = mid - 1;
            }
        }
        
        return leftInd;
    }
    

} 