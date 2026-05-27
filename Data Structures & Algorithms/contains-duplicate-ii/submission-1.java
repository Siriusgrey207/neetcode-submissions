class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> windowNums = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (right - left > k) {
                windowNums.remove(nums[left]);
                left++;
            }
            if (windowNums.contains(nums[right])) {
                return true;
            }
            windowNums.add(nums[right]);
        }

        return false;
    }
}