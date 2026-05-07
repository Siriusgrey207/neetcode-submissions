class Solution {
    public int[] productExceptSelf(int[] nums) {
        // if nums doesn't contain any elements, just return an empty array.
        if (nums.length == 0) return new int[0];
        
        // Create the response array.
        int[] res = new int[nums.length];

        // First pass - every element at index i will contain the products of all the
        // numbers from nums up to index i.
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix = nums[i] * prefix;
        }

        // Second pass - we start from the end this time. This time the res[i] is updated using the suffix and
        // itself, NOT just the suffix.
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix = suffix * nums[i];
        }

        return res;
    }
}  
