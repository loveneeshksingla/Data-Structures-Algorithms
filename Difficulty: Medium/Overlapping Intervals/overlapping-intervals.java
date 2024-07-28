//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        
        Arrays.sort(Intervals, new Comp());
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(Intervals[0][0]);
        temp.add(Intervals[0][1]);
        
        ans.add(temp);
        
        int intervalsSize = Intervals.length;
        
        for(int ind = 1; ind < intervalsSize; ind++) {
            temp = ans.get(ans.size()-1);
            
            if(Intervals[ind][0] <= temp.get(1)) {
                
                int secondNum = Intervals[ind][1] > temp.get(1) ?  Intervals[ind][1] : temp.get(1);
                
                temp.set(1, secondNum);
                
                ans.set(ans.size()-1, temp);
            }else {
                ArrayList<Integer> tempL = new ArrayList<>();
                tempL.add(Intervals[ind][0]);
                tempL.add(Intervals[ind][1]);
                
                ans.add(tempL);
            }
        }
        
        int[][] result = new int[ans.size()][2];
        
        for(int ind = 0; ind < ans.size(); ind++) {
            ArrayList<Integer> curList = ans.get(ind);
            result[ind][0] = curList.get(0);
            result[ind][1] = curList.get(1);
        }
        
        return result;
        
    }
}

class Comp implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return a[0] - b[0];
    }
}