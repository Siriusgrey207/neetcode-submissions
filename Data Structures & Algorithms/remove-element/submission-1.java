class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int leftPtr = 0;
        int rightPtr = nums.length;

        while (leftPtr < rightPtr) {
            if (nums[leftPtr] == val) {
                nums[leftPtr] = nums[rightPtr - 1];
                rightPtr--;
            } else {
                leftPtr++;
            }
        }

        return rightPtr;
    }
}