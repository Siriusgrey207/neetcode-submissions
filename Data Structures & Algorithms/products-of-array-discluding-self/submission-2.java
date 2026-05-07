class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length];

        // First pass - handle the prefix.
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix = prefix * nums[i];
        }

        // Second pass - multiply the recorded values with the suffix.
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix = suffix * nums[i];
        }

        return res;
    }
}  
