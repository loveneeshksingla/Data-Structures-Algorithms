//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList; 


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public ArrayList<String> graycode(int n)
    {
        //code here
        
        if(n == 1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("0");
            ans.add("1");
            return ans;
        }
        
        ArrayList<String> finalRes = new ArrayList<>();
        
        
            ArrayList<String> res = graycode(n-1);
            
            for(int j = 0; j < res.size(); j++) {
                finalRes.add("0" + res.get(j));
            }
            
            for(int j = res.size()-1; j >= 0; j--) {
                finalRes.add("1" + res.get(j));
            }
        
        
        return finalRes;
    }
}


//{ Driver Code Starts.

class BitWise
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			ArrayList<String> ans=obj.graycode(n);
			for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
			    
			System.out.println();
            
            t--;
		}
	}
	
	
}

// } Driver Code Ends