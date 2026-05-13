class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int currentSum = 0;
        // A *prefixSum* : *count* that keep track of how many prefix sums equal to a given value.
        Map<Integer, Integer> prefixSums = new HashMap<>();
        // If we sum 0 elements the result is 0 - we add 1 such sum to the map.
        prefixSums.put(0, 1);

        for (int num : nums) {
            currentSum += num;
            int difference = currentSum - k;
            result += prefixSums.getOrDefault(difference, 0);
            prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }
}