class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int current = numbers[left] + numbers[right];

        while (current != target) {
            if (current > target) {
                right--;
            } else {
                left++;
            }
            current = numbers[left] + numbers[right];
        }

        return new int[] { left + 1, right + 1 };
    }
}
