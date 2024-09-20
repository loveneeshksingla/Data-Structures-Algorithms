//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends




class Solution
{
	public static String rearrangeCharacters(String str) {
	
		int[] freqArr = new int[26];
		int strLen = str.length();
		
		for(int i = 0; i < str.length(); i++) {
		    freqArr[str.charAt(i) - 'a']++; 
		    
		    if(freqArr[str.charAt(i) - 'a'] > (strLen+1)/2) {
		        return "-1";
		    }
		}
		
		char[] ans = new char[str.length()];
		
		int curInd = 0;
		int count = 0;
		
		while(count < str.length()) {
		    
		    int curMaxFreqInd = getCurMaxFreqInd(freqArr);
		    char curChar = (char)('a' + curMaxFreqInd);
		    int curCharFreq = freqArr[curMaxFreqInd];
		    
		    while(curCharFreq > 0) {
		        ans[curInd] = curChar;
		        curInd = curInd + 2;
		        curCharFreq--;
		        if(curInd >= str.length()) {
		            curInd = 1;
		        }
		        count++;
		    }
		    freqArr[curMaxFreqInd] = 0;
		    
		}
		
		String res = new String(ans);
// 		System.out.println(res);
		return res;
		
		
		
	}
	
	
	static int getCurMaxFreqInd(int[] freqArr) {
	    
	    int maxFreq = Integer.MIN_VALUE;
	    int maxFeqInd = -1;
	    
	    for(int i = 0; i < freqArr.length; i++) {
	        if(freqArr[i] > maxFreq) {
	            maxFreq = freqArr[i];
	            maxFeqInd = i;
	        }
	    }
	    
	    return maxFeqInd;
	}
}





