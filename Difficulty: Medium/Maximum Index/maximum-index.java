class Solution {
	int maxIndexDiff(int[] arr) {
		// code here
		int arrLen = arr.length;
		int[] maxArr = new int[arrLen];
		int max = Integer.MIN_VALUE;
		
		for (int ind = arrLen - 1; ind >= 0; ind--) {
			max = Math.max(max, arr[ind]);
			maxArr[ind] = max;
// 			System.out.print(maxArr[ind] + " ");
		}
// 		System.out.println();
		int i = 0;
		int j = 0;
		int maxIndex = 0;
		
		while (i < arrLen && j < arrLen) {
			if (arr[i] <= maxArr[j]) {
				maxIndex = Math.max(maxIndex, j - i);
				j++;
			} else {
				i++;
			}
		}
		
		return maxIndex;
	}
}
