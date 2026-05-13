class Solution {
    public int subarraySum(int[] nums, int k) {
        int currentSum = 0;
        int result = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);

        for (int num : nums) {
            currentSum += num;
            int difference = currentSum - k;

            result += counts.getOrDefault(difference, 0);
            counts.put(currentSum, counts.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }
}