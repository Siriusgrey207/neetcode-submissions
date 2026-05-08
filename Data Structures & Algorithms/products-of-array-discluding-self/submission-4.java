class Solution {
    public int[] productExceptSelf(int[] nums) {
        // If the nums array is empty, the resulting array should also be.
        if (nums.length == 0) return new int[0];

        int[] res = new int[nums.length];

        // First pass - update the i-th element with the prefix and then update the prefix with the
        // i-th element in nums (running product)
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        // Second pass - update the ith element in rest with the suffix, multiplied the already-present
        // value. Then multiply the suffix with the i-th element in nums
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        // Finally return the resultant array.
        return res;
    }
}  
