//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        
        
        int pInd = -1;
        int tInd = -1;
        
        int arrSize = arr.length;
        
        for (int ind = 0; ind < arr.length; ind++) {
            
            if (arr[ind] == 'P' && pInd == -1) {
                pInd = ind;
            }
            
            if (arr[ind] == 'T' && tInd == -1) {
                tInd = ind;
            }
        }
        
        int count = 0;
        
        if (pInd == -1 || tInd == -1) {
            return count;
        }
        
        while (pInd < arrSize && tInd < arrSize) {
            // System.out.println(pInd + "   " + tInd);
            if (Math.abs(pInd - tInd) <= k && tInd < arrSize && pInd < arrSize) {
                count++;
                tInd++;
                if (tInd > 7) {
                    // System.out.println(arr[tInd] + "<tInd========" + tInd);
                }
                while (tInd < arrSize && arr[tInd] != 'T') {
                    tInd++; 
                }
                pInd++;
                while (pInd < arrSize && arr[pInd] != 'P') {
                    pInd++; 
                }
            } else {
                if (pInd < tInd) {
                    pInd++;
                    while (pInd < arrSize && arr[pInd] != 'P') {
                    pInd++; 
                }
                } else {
                    tInd++;
                    while (tInd < arrSize && arr[tInd] != 'T') {
                    tInd++; 
                }
                }
            }
            // System.out.println(count);
            
        }
        
        return count;
    }
}










//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] input = sc.nextLine().trim().split(" ");
            char[] arr = new char[input.length];

            for (int i = 0; i < input.length; i++) {
                arr[i] = input[i].charAt(0);
            }

            int k = Integer.parseInt(sc.nextLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, k));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends