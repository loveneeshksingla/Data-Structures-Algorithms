//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends




class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        
        ArrayList<String> ans = solve(S);
        
        HashSet<String> set = new HashSet<>();
        set.addAll(ans);
        ans.clear();
        ans.addAll(set);
        
        Collections.sort(ans);
        return ans;
        
        
    }
    
    
    
    
    public ArrayList<String> solve(String S) {
        
        if(S.length() == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(S);
            return list;
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < S.length(); i++) {
            String cur = S.charAt(i) + "";
            String newStr = S.substring(0,i) + S.substring(i+1, S.length());
            ArrayList<String> res = solve(newStr);
            
            for(int j = 0; j < res.size(); j++) {
                ans.add(cur+res.get(j));
            }
        }
        
        return ans;
    }
}




