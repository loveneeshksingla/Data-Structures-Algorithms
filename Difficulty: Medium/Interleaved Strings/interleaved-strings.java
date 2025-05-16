//{ Driver Code Starts
// initial code
import java.lang.*;
import java.util.*;

class InterLeaveString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g = new Solution();

            System.out.println(g.isInterLeave(a, b, c) == true ? "true" : "false");
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public boolean isInterLeave(String s1, String s2, String s3) {
        // code here
        
        int[] count = {0};
        boolean res1 = isSubseq(s3, s1, s3.length()-1, s1.length()-1, count);
        
        int[] count1 = {0};
        boolean res2 = isSubseq(s3, s2, s3.length()-1, s2.length()-1, count1);
        
        if (count[0] == s1.length() && count1[0] == s2.length()) return true;
        
        // if (res1 && res2) {
        //     return true;
        // }
        
        return false;
        
    }
    
    public boolean isSubseq(String s1, String s2, int s1Ind, int s2Ind, int[] count) {
        
        if (s2Ind < 0) {
            return true;
        }
        
        if (s1Ind < 0) {
            return false;
        }

        if (s1.charAt(s1Ind) == s2.charAt(s2Ind)) {
            count[0]++;
            return isSubseq(s1, s2, s1Ind-1, s2Ind-1, count);
        } else {
            return isSubseq(s1, s2, s1Ind-1, s2Ind, count);
        }
        
    }
}
