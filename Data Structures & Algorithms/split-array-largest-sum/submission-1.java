class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        int res;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        res = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSplit(mid, nums, k)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private boolean canSplit(int largest, int[] nums, int k) {
        int partitions = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > largest) {
                partitions++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return partitions <= k;
    }
}