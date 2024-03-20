//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] a, int size) {
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
        
        return size - increasingSeq.size();
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
};