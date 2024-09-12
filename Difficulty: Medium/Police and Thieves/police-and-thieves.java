//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 


// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 

        int pol = -1, thi = -1, res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                pol = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'T') {
                thi = i;
                break;
            }
        }

        if (thi == -1 || pol == -1)
            return 0;
        while (pol < n && thi < n) {
            if (Math.abs(pol - thi) <= k) {
                pol++;
                while (pol < n && arr[pol] != 'P')
                    pol++;
                thi = thi + 1;
                while (thi < n && arr[thi] != 'T')
                    thi++;
                res++;
            }

            else if (thi < pol) {
                thi++;
                while (thi < n && arr[thi] != 'T')
                    thi++;
            }
            else {
                pol++;
                while (pol < n && arr[pol] != 'P')
                    pol++;
            }
        }

        return res;
	} 
} 





//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}       
// } Driver Code Ends