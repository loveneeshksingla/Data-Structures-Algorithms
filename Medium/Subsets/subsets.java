//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            ArrayList<Integer> A = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                A.add(arr[i]);
            }

            ArrayList<ArrayList<Integer>> res = new Solution().subsets(A);
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            // System.out.println();
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class NewComparator implements Comparator<ArrayList<Integer>> {
    
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        int size = Math.min(o1.size(), o2.size());
        
        for(int i = 0; i < size; i++) {
            int cmp = o1.get(i).compareTo(o2.get(i));
            if(cmp != 0) {
                return cmp;
            }
        }
        
        return Integer.compare(o1.size(), o2.size());
    }
}

class Solution
{
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> sub = new ArrayList<>();
        ans.add(sub);
        solve(ans, sub, A, 0);
        Collections.sort(ans, new NewComparator());
        
        return ans;
        
        
    }
    
    
    
    
    public static void solve(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> sub, ArrayList<Integer> A, int ind) {
        if(!sub.isEmpty()) {
            ans.add(new ArrayList(sub));
        }
        
        for(int i = ind; i < A.size(); i++) {
            sub.add(A.get(i));
            solve(ans, sub, A, i+1);
            sub.remove(sub.size()-1);
        }
    }
}