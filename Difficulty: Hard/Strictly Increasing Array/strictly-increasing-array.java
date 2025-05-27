

//User function Template for Java

class Solution
{
    public int min_operations(int []nums)
    {
        
        
        int numsLen = nums.length;
        int[] sIC = new int[numsLen];
        Arrays.fill(sIC, 1);
        int max = 1;
        
        for(int i =  1; i < numsLen; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] >= nums[j] && (i - j) <= (nums[i]- nums[j])) {
                    sIC[i] = Math.max(sIC[i], sIC[j]+1);
                    max = Math.max(max, sIC[i]);
                }
            }
        }
        
        
        return numsLen - max;
        
    }
}