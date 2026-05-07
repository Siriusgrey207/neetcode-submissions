class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 0) return new int[0];

        int[] res = new int[numsLength];

        // First pass
        int prefix = 1;
        for (int i = 0; i < numsLength; i++) {
            res[i] = prefix;
            prefix = prefix * nums[i];
        } 

        // Second pass
        int suffix = 1;
        for (int i = numsLength - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
}  
