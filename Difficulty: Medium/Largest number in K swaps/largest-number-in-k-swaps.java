//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}
// } Driver Code Ends




class Ans{
    String max = "";
}

class Solution
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
            //code here.
            Ans r = new Ans();
            r.max= str;
            char[] arr = str.toCharArray();
            solve(arr, k, r);
            return r.max;
        }
        
        
    public static void solve(char[] arr, int k, Ans res) {
        if(k == 0) {
            return;
        }
        
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                
                if(arr[j] > arr[i]) {
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    
                    String newS = new String(arr);
                    
                    if(newS.compareTo(res.max) > 0) {
                        res.max = newS;
                    }
                    
                    solve(arr, k-1, res);
                    
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    
                }
            }
        }
    }
}




